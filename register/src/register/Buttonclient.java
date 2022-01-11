package register;
package register;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

	
	public class buttonclient extends frame {
		
		      JButton r;
			 DefaultTableModel d=new DefaultTableModel();
			 buttonclient (){
				 d.addColumn("Nom");
				 d.addColumn("Prenom");
				 d.addColumn("Age");
				 d.addColumn("service");
				 d.addColumn("preuve");
				 d.addColumn("Contacte");
				 d.addColumn("Region");
				 d.addColumn("Ville");
			final JTable t=new JTable(d); 
			JPanel p=new JPanel(new BorderLayout());
			JPanel s=new JPanel(new FlowLayout(FlowLayout.TRAILING));
			JPanel u=new JPanel(new BorderLayout());
			JButton r=new JButton("BACK");
			s.add(r);
			p.add(s,BorderLayout.CENTER);
			t.getTableHeader().setReorderingAllowed(false);
			u.add(new JScrollPane(t),BorderLayout.CENTER);
			 this.add(p,BorderLayout.SOUTH);
			 this.add(u,BorderLayout.CENTER);
			  this.setTitle("Database resulte");
			  
              try {
          		Connection  con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/vendeur","root","root");
          		String query1="Select* from vendeur.clien";
          		Statement sta=con1.createStatement();
          		ResultSet sr=sta.executeQuery(query1);
          		while(sr.next()) {
          			String nom=sr.getString("Nom");
          			String prenom=sr.getString("prenom");
          			String age=sr.getString("age");
          			String service=sr.getString("service");
          			String preuve=sr.getString("preuve");
          			String contact=sr.getString("contact");
          			String region=sr.getString("Region");
          			String ville=sr.getString("ville");
          			d.addRow(new Object[] {
          				nom,prenom,age,service,preuve,contact,region,ville
          			});
          		}
          		con1.close();
          	}catch(Exception ex) {
          		ex.printStackTrace();
          		System.out.println("SQLExeption"+ex.getMessage());
          		System.out.println("SQLState"+ ((SQLException) ex).getSQLState());
          		System.out.println("vendorError");
          		}
              // panel p=new panel();
            //  p.add(r);
             // p.add(x);
             //this.add(p);
             r.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					if (e.getSource()==r) {
						dispose();
						new visiteur();
					}
					}});
              this.setVisible(true);
		 }
			 

	}
		
	



