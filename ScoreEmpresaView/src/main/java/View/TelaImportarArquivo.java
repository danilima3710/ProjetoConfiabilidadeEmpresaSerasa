package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Controller.ControllerView;
import Model.Empresa;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Toolkit;

public class TelaImportarArquivo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox cbEmpresas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaImportarArquivo dialog = new TelaImportarArquivo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaImportarArquivo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaImportarArquivo.class.getResource("/View/Icone.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ControllerView controllerView = new ControllerView();
				LinkedHashSet<Empresa> empresas = new LinkedHashSet<Empresa>();
				empresas = controllerView.carregaEmpresas(0);
				
				for (Empresa empresa : empresas) {
					cbEmpresas.addItem(empresa);
				}
			}
		});
		setBounds(100, 100, 510, 203);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			cbEmpresas = new JComboBox();
			cbEmpresas.setFont(new Font("Arial", Font.PLAIN, 14));
			cbEmpresas.setModel(new DefaultComboBoxModel(new String[] {"Selecione"}));
			cbEmpresas.setBounds(174, 91, 311, 21);
			contentPanel.add(cbEmpresas);
		}
		
		JLabel lblImportaoDeArquivo = new JLabel("Importação de Arquivo");
		lblImportaoDeArquivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblImportaoDeArquivo.setFont(new Font("Arial", Font.BOLD, 22));
		lblImportaoDeArquivo.setBounds(0, 10, 496, 30);
		contentPanel.add(lblImportaoDeArquivo);
		
		JLabel lblSelecioneUmaEmpresa = new JLabel("Selecione uma empresa:");
		lblSelecioneUmaEmpresa.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSelecioneUmaEmpresa.setBounds(10, 91, 165, 21);
		contentPanel.add(lblSelecioneUmaEmpresa);
		
		JButton btnNewButton = new JButton("Clique aqui...");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerView controllerView = new ControllerView();
				String diretorio=null;
				int id=0;
				JFileChooser arquivo = new JFileChooser();
				FileNameExtensionFilter filtroJSON = new FileNameExtensionFilter("Arquivos JSON", "json");  
				arquivo.addChoosableFileFilter(filtroJSON);
				arquivo.setAcceptAllFileFilterUsed(false);
				if(arquivo.showSaveDialog(arquivo) == JFileChooser.APPROVE_OPTION){
					diretorio = arquivo.getSelectedFile().getAbsolutePath();
				}
				Empresa empresa = ((Empresa)cbEmpresas.getSelectedItem());
				id = ((Empresa)cbEmpresas.getSelectedItem()).getID();
				if (diretorio != null && id != 0) {
					controllerView.importarArquivo(diretorio, id);
					controllerView.calcularRanking(empresa);
					if(controllerView.importarArquivo(diretorio, id)) {
						JOptionPane.showMessageDialog(null, "Arquivo importado com sucesso");
					}else{
						JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar importar o arquivo");
					}
				}
				
				
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setBounds(174, 132, 111, 19);
		contentPanel.add(btnNewButton);
		
		JLabel lblSelecioneUmArquivo = new JLabel("Selecione um arquivo:");
		lblSelecioneUmArquivo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSelecioneUmArquivo.setBounds(10, 133, 133, 17);
		contentPanel.add(lblSelecioneUmArquivo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 476, 106);
		contentPanel.add(separator);
	}

}
