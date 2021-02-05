package com.sathish.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class SampleCurd_Hibernate implements Intrf_Crud_Commmon{

    SessionFactory glbl_session_fac = null;
    Session glbl_session = null;

    @Override
    public int dbConfiguration() {
    	try
    	{
		glbl_session_fac = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		glbl_session = glbl_session_fac.getCurrentSession();
    	}
    	catch(Exception ex)
    	{
    		return -1;
    	}
    	
    	return 1;

    }

    @Override
    public int insertIntoDB() {

        try {
            glbl_session.beginTransaction();

            Student s = new Student();
            s.setStu_id(856);
            s.setStu_mark(75);
            s.setStu_Name("Sam1");
            s.setStu_reg_no(6);
            //setter method to set Student parameters
            glbl_session.save(s);
            glbl_session.getTransaction().commit();

            glbl_session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
        return 1;
    }

    @Override
    public int updateIntoDB() {
        try {
            glbl_session.beginTransaction();
            
            Student s = new Student();
            s.setStu_id(856);
            s.setStu_mark(75);
            s.setStu_Name("Sam2");
            s.setStu_reg_no(6);

            Student loc_stu = glbl_session.get(Student.class, s.getStu_reg_no());

            loc_stu.setStu_Name(s.getStu_Name());;

            glbl_session.update(loc_stu);

            glbl_session.getTransaction().commit();
            glbl_session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
        return 1;
    }

    @Override
    public int deleteIntoDB() {

        try {
            glbl_session.beginTransaction();

//		Student loc_stu = glbl_session.get(Student.class, stu_reg_no);
            Query query = glbl_session.createQuery("from Student where stu_reg_no = :db_reg_no"); //You will get Weayher object
            query.setParameter("db_reg_no", 6);

//		System.out.println(query.getQueryString());
            List<Student> list = query.list(); //You are accessing  as list<WeatherModel>

            glbl_session.delete(list.get(0));
        } catch (Exception ex) {
            return -1;
        } finally {
            glbl_session.close();
        }
        
        return 1;
    }

    @Override
    public int selectFromDB() {
        try {
            glbl_session.beginTransaction();

            Student loc_stu = glbl_session.get(Student.class, 6);
            System.out.println(loc_stu.toString());

            glbl_session.delete(loc_stu);
            return 1;
        } catch (Exception ex) {
            return -1;
        } finally {
            glbl_session.close();
        }

    }

    @Override
    public int closeOperation() {
        glbl_session.close();
        return 1;
    }
	
}
