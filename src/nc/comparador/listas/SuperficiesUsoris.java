package nc.comparador.listas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.HyperlinkEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.net.URL;
import javax.swing.event.HyperlinkListener;

public class SuperficiesUsoris {

	private JFrame frame;
	private JTextField textRuta1, textRuta2, textRuta3, textRuta21, textRuta22, textFilter, textFilter2, textNumber, textNumber2;
	JComboBox<String> tglYN, tglYN2,tglFL,optionZero, optionOne, optionTwo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		// Activar Nimbus y personalizar colores antes de crear la ventana
	    try {
	        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
	        for (int i = 0; i < looks.length; i++) {
	            if ("Nimbus".equals(looks[i].getName())) {
	                UIManager.setLookAndFeel(looks[i].getClassName());
	                break;
	            }
	        }
	        
	        // Personalización de colores globales
	        UIManager.put("control", Color.WHITE); // Fondo general
	        UIManager.put("nimbusBase", Color.WHITE); // Elementos activos

	        UIManager.put("nimbusBlueGrey", new Color(224, 224, 224)); // Gris claro
	        UIManager.put("text", Color.BLACK); // Texto principal
	        UIManager.put("infoText", new Color(176, 176, 176)); // Texto secundario
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuperficiesUsoris window = new SuperficiesUsoris();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SuperficiesUsoris() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("BankGothic Md BT", Font.PLAIN, 13));
		frame.setBounds(100, 100, 450, 660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setLayout(null);
		frame.setTitle("Comparator Indicum");
		
		//Carga del logo de la aplicación.
		URL url1 = SuperficiesUsoris.class.getResource("proyectoBase008.png");
		if (url1 != null) {
			frame.setIconImage(Toolkit.getDefaultToolkit().getImage(url1));
		} else {
			System.err.println("No se encontró pCL.png en el paquete nc.comparador.listas");
		}
		
		// Create the JTabbedPane
	    JTabbedPane tabbedPane = new JTabbedPane();
	    frame.getContentPane().setLayout(new BorderLayout());
	    frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
	    
	    //Colores
	    tabbedPane.setBackground(new Color(230, 230, 230)); // Fondo inactivas
	    tabbedPane.setForeground(Color.BLACK);              // Texto
	    tabbedPane.setOpaque(true);
	    
	    // Panel 1
	    JPanel panel1 = new JPanel();
	    panel1.setLayout(null);
	    
	    // Panel 2
	    JPanel panel2 = new JPanel();
	    panel2.setLayout(null);
	    
	    // Panel 4
	    JPanel panel4 = new JPanel();
	    panel4.setLayout(null);
	    		
	    //Subtitle
	    optionZero = new JComboBox<>();
	    optionZero.setFont(new Font("BankGothic Md BT", Font.BOLD, 13));
		optionZero.setBounds(62, 20, 310, 20);
		optionZero.addItem("Exclusive content in both files");
		optionZero.addItem("Repeated content in both files");
		optionZero.setSelectedIndex(0);
		panel1.add(optionZero);
	    
		JLabel lblRuta1 = new JLabel("1º File text directory:");
		lblRuta1.setFont(new Font("BankGothic Md BT", Font.PLAIN, 11));
		lblRuta1.setBounds(31, 60, 144, 20);
		panel1.add(lblRuta1);		
		 		
		//Here we will get the first location file.
		textRuta1 = new JTextField();
		textRuta1.setFont(new Font("BankGothic Md BT", Font.PLAIN, 9));
		textRuta1.setBounds(186, 60, 170, 20);
		panel1.add(textRuta1);
		textRuta1.setColumns(10);

		// Add MouseListener to open the JFileChooser when clic is made.
		textRuta1.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        JFileChooser fileChooser = new JFileChooser();
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files (.txt)", "txt");	// Filter to only read text files.
		        fileChooser.setFileFilter(filter);
		        //fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Allow to take files or directories.
		        int result = fileChooser.showOpenDialog(frame); // Show the window dialog.

		        if (result == JFileChooser.APPROVE_OPTION) {
		            File selectedFile = fileChooser.getSelectedFile();
		            textRuta1.setText(selectedFile.getAbsolutePath()); //Set the route in the JTextField
		        }
		    }
		});
		
		JLabel lblRuta2 = new JLabel("2º File text directory:");
		lblRuta2.setFont(new Font("BankGothic Md BT", Font.PLAIN, 11));
		lblRuta2.setBounds(31, 100, 144, 20);
		//frame.getContentPane().add(lblRuta2);
		panel1.add(lblRuta2);
		
		//Here we will get the second location file.
		textRuta2 = new JTextField();
		textRuta2.setFont(new Font("BankGothic Md BT", Font.PLAIN, 9));
		textRuta2.setColumns(10);
		textRuta2.setBounds(186, 100, 170, 20);
		//frame.getContentPane().add(textRuta2);
		panel1.add(textRuta2);
		
		// Add MouseListener to open the JFileChooser when clic is made.
				textRuta2.addMouseListener(new MouseAdapter() {
				    @Override
				    public void mouseClicked(MouseEvent e) {
				        JFileChooser fileChooser = new JFileChooser();
				        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files (.txt)", "txt");
				        fileChooser.setFileFilter(filter);
				        //fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Allow to take files or directories.
				        int result = fileChooser.showOpenDialog(frame); // Show the window dialog.

				        if (result == JFileChooser.APPROVE_OPTION) {
				            File selectedFile = fileChooser.getSelectedFile();
				            textRuta2.setText(selectedFile.getAbsolutePath()); //Set the route in the JTextField
				        }
				    }
				});
				
		JLabel lblRuta3 = new JLabel("New text file route:");
		lblRuta3.setFont(new Font("BankGothic Md BT", Font.PLAIN, 11));
		lblRuta3.setBounds(31, 140, 144, 20);
		panel1.add(lblRuta3);
				
		textRuta3 = new JTextField();
		textRuta3.setFont(new Font("BankGothic Md BT", Font.PLAIN, 9));
		textRuta3.setBounds(186, 140, 170, 20);
		panel1.add(textRuta3);
		textRuta3.setColumns(10);
		
		textRuta3.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        JFileChooser directoryChooser = new JFileChooser();

		        // Configuration for only directories.
		        directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		        // Show window dialog to select the directory.
		        int result = directoryChooser.showOpenDialog(frame);

		        if (result == JFileChooser.APPROVE_OPTION) {
		            File selectedDirectory = directoryChooser.getSelectedFile();

		            // Request of the name of the new file.
		            String fileName = JOptionPane.showInputDialog(frame, "Please, write the name of the new file:", "File name", JOptionPane.INFORMATION_MESSAGE);

		            if (fileName != null && !fileName.trim().isEmpty()) {
		            	if (!fileName.endsWith(".txt")) {
		                    fileName += ".txt";
		            	}
		                // Combine route and name.
		                String fullPath = selectedDirectory.getAbsolutePath() + File.separator + fileName.trim();
		                textRuta3.setText(fullPath); // Show full route in JTextField
		            } else {
		                JOptionPane.showMessageDialog(frame, "The name of the file cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        }
		    }
		});
				
		JLabel lblOption1 = new JLabel("Do you want to eliminate even or odd lines?");
		lblOption1.setFont(new Font("BankGothic Md BT", Font.PLAIN, 11));
		lblOption1.setBounds(31, 200, 310, 20);
		//frame.getContentPane().add(lblOption1);
		panel1.add(lblOption1);
		
		//Here we add the options in which the user will select if there is need for futher need of more cleaning. 
		optionOne = new JComboBox<>();
		optionOne.setFont(new Font("BankGothic Md BT", Font.PLAIN, 10));
		optionOne.setBounds(31, 230, 341, 20);
		optionOne.addItem(" Eliminate NO lines.");
		optionOne.addItem(" Eliminate from BOTH .txt files the EVEN lines.");
		optionOne.addItem(" Eliminate from BOTH .txt files the ODD lines.");
		optionOne.addItem(" Eliminate from 1º .txt file the EVEN lines.");
		optionOne.addItem(" Eliminate from 1º .txt file the ODD lines.");
		optionOne.addItem(" Eliminate from 2º .txt file the EVEN lines.");
		optionOne.addItem(" Eliminate from 2º .txt file the ODD lines.");
		optionOne.addItem(" Eliminate EVEN from 1º AND ODD from 2º .txt file.");
		optionOne.addItem(" Eliminate ODD from 1º AND EVEN from 2º .txt file.");
		optionOne.setSelectedIndex(0);
		panel1.add(optionOne);
		
		JLabel lblOptionTwo = new JLabel("Do you want to eliminate the excesive text from each line?");
		lblOptionTwo.setFont(new Font("BankGothic Md BT", Font.PLAIN, 11));
		lblOptionTwo.setBounds(31, 260, 380, 20);
		panel1.add(lblOptionTwo);
		
		tglYN = new JComboBox<>();
		tglYN.setFont(new Font("BankGothic Md BT", Font.PLAIN, 11));
		tglYN.setBounds(31, 290, 343, 20);
		tglYN.addItem(" Negative");
		tglYN.addItem(" Affirmative, for BOTH .txt files.");
		tglYN.addItem(" Affirmative, for 1º .txt file.");
		tglYN.addItem(" Affirmative, for 2º .txt file.");
		panel1.add(tglYN);
		
		JLabel lblFilter = new JLabel("Indicate what character or space act as a filter:");
		lblFilter.setFont(new Font("BankGothic Md BT", Font.PLAIN, 11));
		lblFilter.setBounds(31, 320, 380, 20);
		panel1.add(lblFilter);
		
		textFilter = new JTextField();
		textFilter.setFont(new Font("BankGothic Md BT", Font.PLAIN, 12));
		textFilter.setColumns(10);
		textFilter.setBounds(180, 350, 50, 20);
		panel1.add(textFilter);
		
		JLabel lblNumber = new JLabel("How many times does it appear before the unwanted text?");
		lblNumber.setFont(new Font("BankGothic Md BT", Font.PLAIN, 11));
		lblNumber.setBounds(31, 380, 380, 20);
		panel1.add(lblNumber);
		
		textNumber = new JTextField();
		textNumber.setFont(new Font("BankGothic Md BT", Font.PLAIN, 12));
		textNumber.setColumns(10);
		textNumber.setBounds(180, 410, 50, 20);
		panel1.add(textNumber);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setFont(new Font("BankGothic Md BT", Font.BOLD | Font.ITALIC, 13));
		btnGenerate.setBounds(130, 530, 150, 40);
		panel1.add(btnGenerate);
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				//We check that the relevant fields are valid.
				if (checkFields()) {
					if (!tglYN.getSelectedItem().toString().equals(" Negative")&&validationNumber(textNumber.getText())) {
						//AdministratioIndicum.gestorFiltrado(textRuta1.getText(), textRuta2.getText(), textRuta3.getText(), optionOne.getSelectedIndex(), tglYN.getSelectedIndex(), textFilter.getText(), Integer.parseInt(textNumber.getText()), optionZero.getSelectedIndex());
						IterTabellarium.guardarLista(textRuta3.getText(), IterTabellarium.selectorCargar(textRuta1.getText(), textRuta2.getText(), optionOne.getSelectedIndex(), tglYN.getSelectedIndex(), textFilter.getText(), Integer.parseInt(textNumber.getText()), optionZero.getSelectedIndex()));
					} else {
						//AdministratioIndicum.gestor(textRuta1.getText(), textRuta2.getText(), textRuta3.getText(), optionOne.getSelectedIndex(), optionZero.getSelectedIndex());
						IterTabellarium.guardarLista(textRuta3.getText(), IterTabellarium.selectorCargar(textRuta1.getText(), textRuta2.getText(), optionOne.getSelectedIndex(), 0, null, 0, optionZero.getSelectedIndex()));
					}
					JOptionPane.showMessageDialog(frame, "List generated successfully.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
					
				}else {
					JOptionPane.showMessageDialog(frame, "There are empty or invalid fields!", "Error", JOptionPane.ERROR_MESSAGE);	
				}
			}
		});
		
		//Añadir información de la aplicación de forma que el usuario pueda comprenderlo.
 		JEditorPane htmlPane = new JEditorPane();
		htmlPane.setContentType("text/html");
		htmlPane.setEditable(false);

		try {
		    URL url = SuperficiesUsoris.class.getResource("AdministratioIndicum.html");
		    if (url != null) {
		        htmlPane.setPage(url);
		    } else {
		        htmlPane.setText("<html><body><h2>No se encontró el archivo HTML</h2></body></html>");
		    }
		} catch (IOException e) {
		    htmlPane.setText("<html><body><h2>Error al cargar el HTML</h2></body></html>");
		}
		
		htmlPane.addHyperlinkListener(new HyperlinkListener() {
		    public void hyperlinkUpdate(HyperlinkEvent e){
		    if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
		        try {
		            Desktop.getDesktop().browse(e.getURL().toURI());
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		   }
		});

		JScrollPane scrollPane = new JScrollPane(htmlPane);
		scrollPane.setBounds(10, 10, 410, 570);
		panel4.add(scrollPane);
		
		JLabel lblSubtitle2 = new JLabel("One file content modification:");
		lblSubtitle2.setFont(new Font("BankGothic Md BT", Font.BOLD, 13));
		lblSubtitle2.setBounds(100, 20, 300, 20);
		panel2.add(lblSubtitle2);
		
		JLabel lblRuta21 = new JLabel("1º File text directory:");
		lblRuta21.setFont(new Font("BankGothic Md BT", Font.PLAIN, 11));
		lblRuta21.setBounds(31, 100, 144, 20);
		panel2.add(lblRuta21);
		 		
		//Here we will get the first location file.
		textRuta21 = new JTextField();
		textRuta21.setFont(new Font("BankGothic Md BT", Font.PLAIN, 9));
		textRuta21.setBounds(186, 100, 170, 20);
		panel2.add(textRuta21);
		//frame.getContentPane().add(textRuta1);
		textRuta21.setColumns(10);

		// Add MouseListener to open the JFileChooser when clic is made.
		textRuta21.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        JFileChooser fileChooser = new JFileChooser();
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files (.txt)", "txt");	// Filter to only read text files.
		        fileChooser.setFileFilter(filter);
		        //fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Allow to take files or directories.
		        int result = fileChooser.showOpenDialog(frame); // Show the window dialog.

		        if (result == JFileChooser.APPROVE_OPTION) {
		            File selectedFile = fileChooser.getSelectedFile();
		            textRuta21.setText(selectedFile.getAbsolutePath()); //Set the route in the JTextField
		        }
		    }
		});
		
		JLabel lblRuta22 = new JLabel("New text file route:");
		lblRuta22.setFont(new Font("BankGothic Md BT", Font.PLAIN, 11));
		lblRuta22.setBounds(31, 140, 144, 20);
		panel2.add(lblRuta22);
				
		textRuta22 = new JTextField();
		textRuta22.setFont(new Font("BankGothic Md BT", Font.PLAIN, 9));
		textRuta22.setBounds(186, 140, 170, 20);
		panel2.add(textRuta22);
		textRuta22.setColumns(10);
		
		textRuta22.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        JFileChooser directoryChooser = new JFileChooser();

		        // Configuration for only directories.
		        directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		        // Show window dialog to select the directory.
		        int result = directoryChooser.showOpenDialog(frame);

		        if (result == JFileChooser.APPROVE_OPTION) {
		            File selectedDirectory = directoryChooser.getSelectedFile();

		            // Request of the name of the new file.
		            String fileName = JOptionPane.showInputDialog(frame, "Please, write the name of the new file:", "File name", JOptionPane.INFORMATION_MESSAGE);

		            if (fileName != null && !fileName.trim().isEmpty()) {
		            	if (!fileName.endsWith(".txt")) {
		                    fileName += ".txt";
		            	}
		                // Combine route and name.
		                String fullPath = selectedDirectory.getAbsolutePath() + File.separator + fileName.trim();
		                textRuta22.setText(fullPath); // Show full route in JTextField
		            } else {
		                JOptionPane.showMessageDialog(frame, "The name of the file cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        }
		    }
		});
				
		JLabel lblOption12 = new JLabel("Do you want to eliminate even or odd lines?");
		lblOption12.setFont(new Font("BankGothic Md BT", Font.PLAIN, 11));
		lblOption12.setBounds(31, 200, 310, 20);
		panel2.add(lblOption12);
		
		//Here we add the options in which the user will select if there is need for futher need of more cleaning. 
		optionTwo = new JComboBox<>();
		optionTwo.setFont(new Font("BankGothic Md BT", Font.PLAIN, 10));
		optionTwo.setBounds(31, 230, 341, 20);
		optionTwo.addItem(" Eliminate NO lines.");
		optionTwo.addItem(" Eliminate EVEN lines.");
		optionTwo.addItem(" Eliminate ODD lines.");
		optionTwo.setSelectedIndex(0);
		panel2.add(optionTwo);
		
		JLabel lblOptionTwo2 = new JLabel("Do you want to eliminate the excesive text from each line?");
		lblOptionTwo2.setFont(new Font("BankGothic Md BT", Font.PLAIN, 11));
		lblOptionTwo2.setBounds(31, 260, 380, 20);
		panel2.add(lblOptionTwo2);
		
		tglYN2 = new JComboBox<>();
		tglYN2.setFont(new Font("BankGothic Md BT", Font.PLAIN, 11));
		tglYN2.setBounds(31, 290, 343, 20);
		tglYN2.addItem(" Negative");
		tglYN2.addItem(" Affirmative");
		panel2.add(tglYN2);
		
		JLabel lblFilter2 = new JLabel("Indicate what character or space act as a filter:");
		lblFilter2.setFont(new Font("BankGothic Md BT", Font.PLAIN, 11));
		lblFilter2.setBounds(31, 320, 380, 20);
		panel2.add(lblFilter2);
		
		textFilter2 = new JTextField();
		textFilter2.setFont(new Font("BankGothic Md BT", Font.PLAIN, 12));
		textFilter2.setColumns(10);
		textFilter2.setBounds(180, 350, 50, 20);
		panel2.add(textFilter2);
		
		JLabel lblNumber2 = new JLabel("How many times does it appear before the unwanted text?");
		lblNumber2.setFont(new Font("BankGothic Md BT", Font.PLAIN, 11));
		lblNumber2.setBounds(31, 380, 380, 20);
		panel2.add(lblNumber2);
		
		textNumber2 = new JTextField();
		textNumber2.setFont(new Font("BankGothic Md BT", Font.PLAIN, 12));
		textNumber2.setColumns(10);
		textNumber2.setBounds(180, 410, 50, 20);
		panel2.add(textNumber2);
		
		JButton btnGenerate2 = new JButton("Generate");
		btnGenerate2.setFont(new Font("BankGothic Md BT", Font.BOLD | Font.ITALIC, 13));
		btnGenerate2.setBounds(130, 530, 150, 40);
		panel2.add(btnGenerate2);
		btnGenerate2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				//We check that the relevant fields are valid.
				if (checkFields2()) {
					if (!tglYN2.getSelectedItem().toString().equals(" Negative")&&validationNumber(textNumber2.getText())) {
						IterTabellarium.guardarLista(textRuta22.getText(), IterTabellarium.cargarStandalone(textRuta21.getText(), optionTwo.getSelectedIndex(), tglYN2.getSelectedIndex(), textFilter2.getText(), Integer.parseInt(textNumber2.getText())));
						} else {
							IterTabellarium.guardarLista(textRuta22.getText(), IterTabellarium.cargarStandalone(textRuta21.getText(), optionTwo.getSelectedIndex(), 0, null, 0));
					}
					JOptionPane.showMessageDialog(frame, "List generated successfully.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(frame, "There are empty or invalid fields!", "Error", JOptionPane.ERROR_MESSAGE);						
				}
			}
		});
		
		tabbedPane.addTab("Information", panel4);
		tabbedPane.addTab("Exclusive/Repeated files content", panel1);
		tabbedPane.addTab("Solo modification", panel2);
		
		// Show the JFrame
	    frame.setVisible(true);
	}
	
	public boolean checkFields() {
		boolean auxBoolean=true;
		
		if (textRuta1.getText().isEmpty() || textRuta2.getText().isEmpty() || textRuta3.getText().isEmpty()) {
			auxBoolean=false;
		} else if (!tglYN.getSelectedItem().toString().equals(" Negative") && textFilter.getText().isEmpty() || !tglYN.getSelectedItem().toString().equals(" Negative") && textNumber.getText().isEmpty()) {
			auxBoolean=false;
		}
		
		return auxBoolean;
	}
	
	public boolean checkFields2() {
		boolean auxBoolean=true;
		
		if (textRuta21.getText().isEmpty() || textRuta22.getText().isEmpty()) {
			auxBoolean=false;
		} else if (!tglYN2.getSelectedItem().toString().equals(" Negative") && textFilter2.getText().isEmpty() || !tglYN2.getSelectedItem().toString().equals(" Negative") && textNumber2.getText().isEmpty()) {
			auxBoolean=false;
		}
		
		return auxBoolean;
	}
	
	public boolean validationNumber(String num) {
		try {
			Integer.parseInt(num);
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "Mandatory to use a number in last field!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
}
