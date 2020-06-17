package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ControllerView;
import Model.Empresa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedHashSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class TelaAtualizaEmpresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNomeEmpresa;
	private JTextField txtQtdNotasEmitidas;
	private JTextField txtQtdDebitosPendentes;
	private JComboBox cbEmpresas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaAtualizaEmpresa dialog = new TelaAtualizaEmpresa();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaAtualizaEmpresa() {
		setTitle("Atualizar");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaAtualizaEmpresa.class.getResource("/View/Icone.png")));
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
		setBounds(100, 100, 450, 290);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAtualizarEmpresas = new JLabel("Atualizar Empresas");
			lblAtualizarEmpresas.setHorizontalAlignment(SwingConstants.CENTER);
			lblAtualizarEmpresas.setFont(new Font("Arial", Font.BOLD, 22));
			lblAtualizarEmpresas.setBounds(0, 0, 436, 40);
			contentPanel.add(lblAtualizarEmpresas);
		}
		{
			JLabel lblSelecioneAEmpresa = new JLabel("Selecione a empresa que deseja alterar");
			lblSelecioneAEmpresa.setFont(new Font("Arial", Font.PLAIN, 12));
			lblSelecioneAEmpresa.setBounds(10, 66, 230, 13);
			contentPanel.add(lblSelecioneAEmpresa);
		}
		{
			cbEmpresas = new JComboBox();
			cbEmpresas.setFont(new Font("Arial", Font.PLAIN, 12));
			cbEmpresas.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					Empresa empresa = new Empresa();
					ControllerView controllerView = new ControllerView();
					if(cbEmpresas.getSelectedIndex() != 0) {
						empresa = controllerView.carregaUmaEmpresa(((Empresa)cbEmpresas.getSelectedItem()).getID());
						txtNomeEmpresa.setText(empresa.getNome());
						txtQtdDebitosPendentes.setText(Integer.toString(empresa.getQntdDebitoPendente()));
						txtQtdNotasEmitidas.setText(Integer.toString(empresa.getQtdNotasEmitidas()));	
					}else {
						txtNomeEmpresa.setText("");
						txtQtdDebitosPendentes.setText("");
						txtQtdNotasEmitidas.setText("");
					}
				}
			});
			cbEmpresas.setModel(new DefaultComboBoxModel(new String[] {"Selecionar..."}));
			cbEmpresas.setBounds(237, 62, 159, 21);
			contentPanel.add(cbEmpresas);
		}
		{
			JLabel lblNomeDaEmpesa = new JLabel("Nome da Empesa");
			lblNomeDaEmpesa.setFont(new Font("Arial", Font.PLAIN, 12));
			lblNomeDaEmpesa.setBounds(10, 126, 159, 13);
			contentPanel.add(lblNomeDaEmpesa);
		}
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 89, 436, 13);
		contentPanel.add(separator);
		
		txtNomeEmpresa = new JTextField();
		txtNomeEmpresa.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNomeEmpresa.setBounds(246, 126, 150, 19);
		contentPanel.add(txtNomeEmpresa);
		txtNomeEmpresa.setColumns(10);
		
		JLabel lblQuantidadeDeNotas = new JLabel("Quantidade de notas emitidas");
		lblQuantidadeDeNotas.setFont(new Font("Arial", Font.PLAIN, 12));
		lblQuantidadeDeNotas.setBounds(10, 149, 182, 13);
		contentPanel.add(lblQuantidadeDeNotas);
		
		JLabel lblQuantidadeDeDbitos = new JLabel("Quantidade de débitos pendentes");
		lblQuantidadeDeDbitos.setFont(new Font("Arial", Font.PLAIN, 12));
		lblQuantidadeDeDbitos.setBounds(10, 172, 194, 13);
		contentPanel.add(lblQuantidadeDeDbitos);
		
		txtQtdNotasEmitidas = new JTextField();
		txtQtdNotasEmitidas.setFont(new Font("Arial", Font.PLAIN, 12));
		txtQtdNotasEmitidas.setEditable(false);
		txtQtdNotasEmitidas.setBounds(246, 149, 150, 19);
		contentPanel.add(txtQtdNotasEmitidas);
		txtQtdNotasEmitidas.setColumns(10);
		
		txtQtdDebitosPendentes = new JTextField();
		txtQtdDebitosPendentes.setFont(new Font("Arial", Font.PLAIN, 12));
		txtQtdDebitosPendentes.setEditable(false);
		txtQtdDebitosPendentes.setBounds(246, 172, 150, 19);
		contentPanel.add(txtQtdDebitosPendentes);
		txtQtdDebitosPendentes.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empresa empresa = new Empresa();
				ControllerView controllerView = new ControllerView();
				
				empresa = (Empresa) cbEmpresas.getSelectedItem();
				if (txtNomeEmpresa.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O campo nome da empresa não pode estar vazio");
				}else {
					empresa.setNome(txtNomeEmpresa.getText());
					controllerView.atualizaEmpresa(empresa);
					JOptionPane.showMessageDialog(null, "Empresa atualizada com sucesso");
				}	
			}
		});
		btnAtualizar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAtualizar.setBounds(167, 216, 112, 27);
		contentPanel.add(btnAtualizar);
	}
}
