package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ControllerView;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Toolkit;

public class TelaCadastrarEmpresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNomeEmpresa;
	private JTextField txtQtdDebitoPendente;
	private JTextField txtQtdNotasEmitidas;
	private JLabel lblCadastroDeEmpresa;
	private JLabel lblNomeDaEmpresa;
	private JLabel lblQuantidadeDe;
	private JLabel lblNotasEmitidas;
	private JLabel lblQuantidadeDe_1;
	private JLabel lblDebitosPendentes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaCadastrarEmpresa dialog = new TelaCadastrarEmpresa();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaCadastrarEmpresa() {
		setTitle("Cadastrar");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastrarEmpresa.class.getResource("/View/Icone.png")));
		setBounds(100, 100, 311, 285);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtNomeEmpresa = new JTextField();
		txtNomeEmpresa.setBounds(156, 59, 125, 28);
		contentPanel.add(txtNomeEmpresa);
		txtNomeEmpresa.setColumns(10);
		
		txtQtdDebitoPendente = new JTextField();
		txtQtdDebitoPendente.setBounds(156, 136, 125, 29);
		contentPanel.add(txtQtdDebitoPendente);
		txtQtdDebitoPendente.setColumns(10);
		
		txtQtdNotasEmitidas = new JTextField();
		txtQtdNotasEmitidas.setBounds(156, 97, 125, 29);
		contentPanel.add(txtQtdNotasEmitidas);
		txtQtdNotasEmitidas.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerView controllerView = new ControllerView();
				controllerView.cadastrarEmpresa(txtNomeEmpresa.getText(), Integer.parseInt(txtQtdDebitoPendente.getText()), Integer.parseInt(txtQtdNotasEmitidas.getText()));
				JOptionPane.showMessageDialog(null, "Empresa cadastrada com sucesso");
				txtNomeEmpresa.setText("");
				txtQtdDebitoPendente.setText("");
				txtQtdNotasEmitidas.setText("");
			}
		});
		btnCadastrar.setBounds(105, 204, 101, 28);
		contentPanel.add(btnCadastrar);
		
		lblCadastroDeEmpresa = new JLabel("Cadastro de Empresa");
		lblCadastroDeEmpresa.setFont(new Font("Arial", Font.BOLD, 22));
		lblCadastroDeEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeEmpresa.setBounds(23, 10, 258, 21);
		contentPanel.add(lblCadastroDeEmpresa);
		
		lblNomeDaEmpresa = new JLabel("Nome da Empresa");
		lblNomeDaEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeDaEmpresa.setBounds(23, 63, 101, 16);
		contentPanel.add(lblNomeDaEmpresa);
		
		lblQuantidadeDe = new JLabel("Quantidade de ");
		lblQuantidadeDe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuantidadeDe.setBounds(23, 97, 85, 13);
		contentPanel.add(lblQuantidadeDe);
		
		lblNotasEmitidas = new JLabel("Notas emitidas");
		lblNotasEmitidas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNotasEmitidas.setBounds(23, 111, 85, 13);
		contentPanel.add(lblNotasEmitidas);
		
		lblQuantidadeDe_1 = new JLabel("Quantidade de");
		lblQuantidadeDe_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuantidadeDe_1.setBounds(23, 138, 85, 13);
		contentPanel.add(lblQuantidadeDe_1);
		
		lblDebitosPendentes = new JLabel("Debitos pendentes");
		lblDebitosPendentes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDebitosPendentes.setBounds(23, 154, 123, 13);
		contentPanel.add(lblDebitosPendentes);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 39, 277, 155);
		contentPanel.add(separator);
	}
}
