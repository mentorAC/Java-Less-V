package com.ExtraShop.Shop.data.repositories;

import com.ExtraShop.Shop.models.PaymentMethod;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
@Service
public class PaymentMethodRepositoryReliz {
    public PaymentMethod getById(int id, Connection connection) throws Exception{
        var statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM Paymant_types WHERE id = "+id);
        PaymentMethod method = null;
        while(result.next()){
            method = new PaymentMethod(result.getInt("id"),result.getString("name"));
            break;
        }
        result.close();
        statement.close();
        return method;


    }
    public ArrayList<PaymentMethod>  getAllMethod(Connection connection) throws Exception {
        var statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM Paymant_types ");
        ArrayList<PaymentMethod> list = new ArrayList<>();
        while (result.next()){
            PaymentMethod method = new PaymentMethod();
            method.setId(result.getInt("id"));
            method.setName(result.getString("name"));
            list.add(method);
        }
        statement.close();
        result.close();
        return list;
    }

    public PaymentMethod create (String payment,Connection connection)throws Exception{
        var statement = connection.createStatement();
        String insertPaymentTypeQuery = "INSERT INTO paymant_types (name) VALUE ('"+payment+"')";
        statement.executeUpdate(insertPaymentTypeQuery);
        ResultSet result = statement.executeQuery("select lastval()");
        int id=0;
        if (result.next()) {
            id = result.getInt(1);
        }


        result.close();
        statement.close();
        var method = new PaymentMethod(id,payment);
        return method;

    }
    public void update(int id, String name,Connection connection) throws Exception {
        var statement = connection.createStatement();
        String updateQuery = "UPDATE Paymant_types SET name = '" + name + "' WHERE id = " + id;
        statement.executeUpdate(updateQuery);
        statement.close();
    }
    public void delete(int id, Connection connection) throws Exception {
        var statement = connection.createStatement();
        String deleteQuery = "DELETE FROM Paymant_types WHERE id = " + id;
        statement.executeUpdate(deleteQuery);
        statement.close();
    }



}
