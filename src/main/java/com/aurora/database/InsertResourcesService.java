package com.aurora.database;

import com.aurora.database.models.MaterialMetadata;
import com.aurora.utils.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InsertResourcesService {

    private final Logger logger = LogManager.getLogger();

    Connection con;

    public InsertResourcesService() {
    }

    private void initConnection(){
        try {
            this.con = DatabaseConnection.getConnection();
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
    }

    public void insert(DatabaseModel databaseModel){

        String insertStatement = this.generateInsertStatement(databaseModel);
        PreparedStatement preparedStatement = null;

       try{
           preparedStatement = this.con.prepareStatement(insertStatement);
       }catch (SQLException e){
           logger.error(e.getMessage());
       }




    }

    private String generateInsertStatement(DatabaseModel databaseModel){
        Integer id = this.insertMetadataRegistry((MaterialMetadata) databaseModel);
        Map<String, String> model = databaseModel.getColumnsValuesStructure();
        model.put("material_id", id.toString());

        List<String> colums = new ArrayList<String>(model.keySet());
        List<String> columnsValues = new ArrayList<String>(model.values());

        StringBuilder sb = new StringBuilder();
        PreparedStatement insertMaterialStatement = null;

        sb.append("insert into ");
        sb.append(databaseModel.getTableName());
        sb.append("(");

        for (int i = 0; i < colums.size(); i++) {
            if (i < colums.size() - 1) {
                sb.append(colums.get(i)).append(",");
            }else{
                sb.append(colums.get(i)).append(")");
            }

        }
        sb.append(" values(");
        for (int i = 0; i < colums.size(); i++) {
            if (i < colums.size() - 1) {
                sb.append("?,");
            }else{
                sb.append("?);");
            }
        }

      try {
          insertMaterialStatement = this.con.prepareStatement(sb.toString());
          for (int i = 0; i < colums.size(); i++) {
              insertMaterialStatement.setString(i + 1, columnsValues.get(i));
          }
          insertMaterialStatement.executeUpdate();
          DatabaseConnection.close(insertMaterialStatement);
          logger.info("Material inserted successfully");
      }catch (SQLException e){
          logger.error(e.getMessage());
      }



        logger.info(sb);
        return sb.toString();
    }


    private Integer insertMetadataRegistry(MaterialMetadata materialMetadata){


        Integer newId = 0;
      switch (materialMetadata.resourceType){
          case BOOK:
            newId = this.executeMetadataStatements(materialMetadata.getTitle(),"book","LIB");
          break;
          case MAGAZINE:
              newId = this.executeMetadataStatements(materialMetadata.getTitle(),"magazine","REV");
          break;
          case CD:
              newId = this.executeMetadataStatements(materialMetadata.getTitle(),"cd","CDA");
          break;
          case DVD:
              newId = this.executeMetadataStatements(materialMetadata.getTitle(),"dvd","DVD");
          break;
      }
      return  newId;
    };

    private Integer executeMetadataStatements(String title, String resourceType, String internalPrefix){
        Integer newId = 0;
        initConnection();
        String metadataStatement = "insert into material_metadata(title, material_type, internal_id) values(?,?, '');";
        String setInternalIdStatement = "update material_metadata set internal_id = ? where id = ?;";

        PreparedStatement preparedInternalIdStatement = null;
        PreparedStatement preparedStatement = null;

        try {

            preparedStatement = this.con.prepareStatement(metadataStatement, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, resourceType);
            preparedStatement.executeUpdate();


            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()){
                newId = generatedKeys.getInt(1);
                String idWithZeros = StringUtils.addLeadingZeros(newId.toString());
                String internalId = internalPrefix+ idWithZeros;

                preparedInternalIdStatement = this.con.prepareStatement(setInternalIdStatement);
                preparedInternalIdStatement.setString(1, internalId);
                preparedInternalIdStatement.setInt(2, newId);
                preparedInternalIdStatement.executeUpdate();


                logger.info("Nuevo metadata registro generado:"+internalId);
            }

        }catch (SQLException e){
            logger.error(e.getMessage());
        }finally {
            DatabaseConnection.close(this.con);
            DatabaseConnection.close(preparedStatement);
            DatabaseConnection.close(preparedInternalIdStatement);
        }
        return  newId;
    }

}
