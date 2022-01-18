
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

	
	public class recherche extends frame {
		 JTable t;
		 JButton r,o;
		 textfield fs;
		 JPanel u;
		DefaultTableModel d;
			    recherche (){
			    	d=new DefaultTableModel();
				 d.addColumn("Nom");
				 d.addColumn("Prenom");
				 d.addColumn("Age");
				 d.addColumn("service");
				 d.addColumn("preuve");
				 d.addColumn("Contacte");
				 d.addColumn("Region");
				 d.addColumn("Ville");
			t=new JTable(d); 
			JPanel p=new JPanel(new BorderLayout());
			JPanel s=new JPanel();
			JPanel q=new JPanel(new BorderLayout());
			JPanel q1=new JPanel();
			JPanel q2=new JPanel();
			q.setLayout(new FlowLayout());
		     u=new JPanel(new BorderLayout());
		     //t.getTableHeader().setReorderingAllowed(false);
				u.add(new JScrollPane(t),BorderLayout.CENTER);
			JButton r=new JButton("Page d'accueille");
			o=new JButton("Rechercher");
			fs=new textfield();
			label x=new label();
			x.setText("Veillez rechecher un service");
			q.add(x);
			//JButton c=new JButton("SERVICE NON trouver");
			q1.setBackground(Color.yellow);
			s.setBackground(Color.orange);
			q2.setBackground(Color.green);
			q.setBackground(Color.orange);
			label c1=new label();
			c1.setText("veillez reperer un SERVICE et CONTACTER la personne parfaite");
			q.add(fs);
			q.add(o);
			p.add(r);
			//r.setSize(new Dimension(100,100));
			s.add(c1);
			s.add(r);
			p.add(s);
			t.getTableHeader().setReorderingAllowed(false);
			u.add(new JScrollPane(t),BorderLayout.CENTER);
			 this.add(p,BorderLayout.SOUTH);
			 this.add(u,BorderLayout.CENTER);
			 this.add(q,BorderLayout.NORTH);
			 this.add(q1,BorderLayout.EAST);
			 this.add(q2,BorderLayout.WEST);
			 this.setTitle("Database resulte");
			  
              try {
          		Connection  con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/vendeur","root","root");
          		String query1="Select* from vendeur.clien ";
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
          			d=(DefaultTableModel)t.getModel();
          			d.addRow(new Object[] {
          					nom,prenom,age,service,preuve,contact,region,ville
          			});
          		}
          			con1.close();
              }catch(Exception ex) {
          		
          		ex.printStackTrace();
          		System.out.print("SQLExeption"+ex.getMessage());
          		System.out.println("SQLState"+ ((SQLException) ex).getSQLState());
          		System.out.println("vendorError");
          	}
           
             r.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					if (e.getSource()==r) {
						dispose();
						new visiteur();
					}
					}});    
             this.setVisible(true);
			    TableRowSorter dr=new TableRowSorter(d);
	            o.addActionListener(new ActionListener() { 
	            	
					public void actionPerformed(ActionEvent e) {
						if(e.getSource()==o) {
						String ser=fs.getText().trim();
						t.setRowSorter(dr);
						   if(ser.length()!=0) {
							   dr.setRowFilter(RowFilter.regexFilter(ser));   
						   }
						   else {
							  dr.setRowFilter(null); 
						   }
					}}
						
					 }); 
			    
			    
	}  }      
			    
			    
