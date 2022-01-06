package register;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class tester extends JFrame  {
	JButton b;
	JButton r;
	JButton v;
	textfield Nom1;
	textfield prenom11;
	age ages;
	textfield service11;
	textfield preuve1;
	textfield Region1;
	textfield ville1;
	Number n;
	 tester(){
	
	frame f=new frame();
	panel p=new panel();
	JLabel br=new JLabel();
	br.setText("New register");
	br.setFont(new Font("Times new Romain",Font.PLAIN,40));
	br.setBounds(365,32,325,50);
	p.add(br);
	
	label welcom=new label();
	welcom.setText("welcome");
	welcom.setBounds(550,50,400,100);
	welcom.setFont(new Font("Times new Romain",Font.PLAIN,35));
	p.add(welcom);
	
	
	label nom=new label();
	nom.setText("Nom");
	nom.setBounds(58,200,100,45);
	p.add(nom);
	
	label prenom=new label();
	prenom.setText("prenoms");
	prenom.setBounds(58,250,110,55);
	p.add(prenom);
	
	label age=new label();
	age.setText("Age");
	age.setBounds(58,300,200,55);
	p.add(age);
	
	label services=new label();
	services.setText("service");
	services.setBounds(58,350,200,55);
	p.add(services);
	
	label  Contact=new label();
	Contact.setText("Contact");
	Contact.setBounds(58,400,200,55);
	p.add(Contact);
	
	label preuves=new label();
	preuves.setText("Preuves");
	preuves.setBounds(458,200,200,55);
	p.add(preuves);
	
	label Region=new label();
	Region.setText("Region");
	Region.setBounds(458,250,200,55);
	p.add(Region);
	
	label ville=new label();
	ville.setText("VILLE");
	ville.setBounds(458,300,200,55);
	p.add(ville);
	
	Nom1=new textfield();
	Nom1.setBounds(200,205,200,45);
	p.add(Nom1);
	
	prenom11=new textfield();
	prenom11.setBounds(200,255,200,45);
	p.add(prenom11);
	
	
	ages=new age();
	ages.setBounds(200,305,200,45);
	p.add(ages);
	
	service11=new textfield();
	service11.setBounds(200,355,200,45);
	p.add(service11);
	
	n=new Number();
	n.setBounds(200,405,200,45);
	p.add(n);
	
	preuve1=new textfield();
	preuve1.setBounds(600,205,200,45);
	p.add(preuve1);
	
	Region1=new textfield();
	Region1.setBounds(600,255,200,45);
	p.add(Region1);
    ville1=new textfield();
	ville1.setBounds(600,305,200,45);
	p.add(ville1);
    ImageIcon q=new ImageIcon("vivre-ensemble-photo.jpg");
    f.setIconImage(q.getImage());
    f.setTitle("Ensemble nous pouvons");
    Panel o=new Panel();
    p.setSize(123,142);
     o.setBackground(new Color(123,15,100));
	  o.setSize(133,124);
	    b=new JButton("Enregistrez ");
		b.setBounds(350,500,100,30);
		r=new JButton("BACK");					
		r.setBounds(500,500,100,30);
		v=new JButton("CLOSE");
		v.setBounds(650,500,100,30);
		//l.setBackground(Color.black);
		//l.setOpaque(true);
		 p.add(r);
	     p.add(b);
	     p.add(v);
	    // p.add(l);
	 f.add(o,BorderLayout.NORTH);
	f.add(p,BorderLayout.CENTER);
	f.setVisible(true);
	v.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==v) {
			   f.dispose();
			}
			
		}
		
	});
	r.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==r) {
				f.dispose();
				//new visiteur();
			}
			
		}
		
	});
	 b.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b) {
		String Nom=Nom1.getText();
		String prenom=prenom11.getText();
		String age=ages.getText();
		String service=service11.getText();
		String preuve= preuve1.getText();
		String region= Region1.getText();
		String contact=n.getText();
		String ville=ville1.getText();
		String msg=""+Nom;
		msg+="\n";
		if(age.length()>2) {
			JOptionPane.showMessageDialog(null, "Desolé vous ne pouvez vous enregistrez avec cet Age");	
		}
		else if(Nom.isEmpty()) {
		JOptionPane.showMessageDialog(null, "veillez saisir un nom svp");
		}
		else if(prenom.isEmpty()) {
			JOptionPane.showMessageDialog(null, "veillez saisir un prenom svp");
			}
		else if(age.isEmpty()) {
			JOptionPane.showMessageDialog(null, "veillez entrz votre age svp");
			}
		else if(service.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Quel service rendez vous ?");
			}
		else if(contact.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Comment vous joindre ?svp");
			}
		else if(preuve.isEmpty()) {
			JOptionPane.showMessageDialog(null, "saisir une preuve ou saisir 'Rien'svp");
			}
		else if(region.isEmpty()) {
			JOptionPane.showMessageDialog(null, "C'est important d'indiquer votre region");
			}
		else if(ville.isEmpty()) {
			JOptionPane.showMessageDialog(null, "votre ville svp");
			
		}
		//if(Nom.isEmpty()||prenom.isEmpty()||age.isEmpty()||ville.isEmpty()||contact.isEmpty()
			//	||region.isEmpty()||service.isEmpty()||preuve.isEmpty()) {
			//JOptionPane.showMessageDialog(null, "veillez Remplir tous les champs SVP");
		//}
		else {
    try {
		Connection  con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/vendeur","root","root");
		String query1="INSERT INTO vendeur.clien values('"+ Nom +"','"+ prenom +"','"+age+"','"+service+"','"+preuve+"','"+contact+"','"+region+"','"+ville+"')";
		Statement sta=con1.createStatement();
		int x=sta.executeUpdate(query1);
		if(x>=1) {
			JOptionPane.showMessageDialog(b, "Bienvenu Monseur/madame:"+msg+"VOUS AVEZ ETE ENREGISTRE AVEC SUCCES");
		}
		else {
			JOptionPane.showMessageDialog(b, "ceci existe déjà");
		}
		con1.close();
	}catch(Exception ex) {
		ex.printStackTrace();
		System.out.println("SQLExeption"+ex.getMessage());
		System.out.println("SQLState"+ ((SQLException) ex).getSQLState());
		System.out.println("vendorError");
		}
		}	
			
	}
	}
	
	});
	
	 
	 }
}

