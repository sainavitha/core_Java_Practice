package com.navitha.HibernateDemo1;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.mysql.cj.x.protobuf.MysqlxConnection.Compression;

public class App 
{

	public static void main( String[] args )
    {
  Empinfo emp=new  Empinfo();
  emp.setEid(90);
  emp.setEname("Lalitha");
  emp.setAge(26);
  emp.setEid(20);
  emp.setEname("Navitha");
  emp.setAge(27);
  Configuration con=new Configuration().configure().addAnnotatedClass(Empinfo.class);
  SessionFactory sf= con.buildSessionFactory();
  Session session = sf.openSession();
  Transaction tx=session.beginTransaction();
  session.save(emp);
  tx.commit();
    }	
}
