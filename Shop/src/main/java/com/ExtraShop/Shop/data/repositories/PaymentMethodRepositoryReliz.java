package com.ExtraShop.Shop.data.repositories;

import com.ExtraShop.Shop.models.PaymentMethod;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
@Service
public class PaymentMethodRepositoryReliz {
    private final DbContextService dbContextService;
    public PaymentMethod getById(int id) throws Exception{
        var statement = dbContextService.getConnection().createStatement();
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
    public ArrayList<PaymentMethod>  getAllMethod() throws Exception {
        var statement = dbContextService.getConnection().createStatement();
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

    public PaymentMethod create (String payment)throws Exception{
        var statement = dbContextService.getConnection().createStatement();
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
    public PaymentMethodRepositoryReliz(DbContextService dbContextService){
        this.dbContextService = dbContextService;
    }
}
