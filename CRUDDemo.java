package com.sathish.demo;

public class CRUDDemo {
    Intrf_Crud_Commmon obj_intrf_crud = null;
    boolean is_jdbc = true;
    

    public CRUDDemo() {
        
        if(is_jdbc)
        {
            obj_intrf_crud = new SampleCurd_JDBC();
            obj_intrf_crud.dbConfiguration();
        }
        else
        {
            obj_intrf_crud = new SampleCurd_Hibernate();
            obj_intrf_crud.dbConfiguration();
        }
    }
    
    public void dbInsert()
    {
        obj_intrf_crud.insertIntoDB();
    }
    
    public void dbUpdate()
    {
        obj_intrf_crud.updateIntoDB();
    }

    public void dbSelect()
    {
        obj_intrf_crud.selectFromDB();
    }    

    public void dbDelete()
    {
        obj_intrf_crud.deleteIntoDB();
    }    
    
    
    
    public static void main(String[] args) {
        CRUDDemo obj_crud_demo = new CRUDDemo();
        
        obj_crud_demo.dbInsert();
    }
    
}


