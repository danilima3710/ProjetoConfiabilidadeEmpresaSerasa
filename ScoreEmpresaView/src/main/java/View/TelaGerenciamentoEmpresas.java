package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Toolkit;

public class TelaGerenciamentoEmpresas extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaGerenciamentoEmpresas dialog = new TelaGerenciamentoEmpresas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaGerenciamentoEmpresas() {
		setTitle("Gerenciador");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaGerenciamentoEmpresas.class.getResource("/View/Icone.png")));
		setBounds(100, 100, 367, 284);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblGerenciamentoDeEmpresas = new JLabel("Gerenciamento de Empresas");
			lblGerenciamentoDeEmpresas.setFont(new Font("Arial", Font.BOLD, 22));
			lblGerenciamentoDeEmpresas.setHorizontalAlignment(SwingConstants.CENTER);
			lblGerenciamentoDeEmpresas.setBounds(10, 10, 333, 33);
			contentPanel.add(lblGerenciamentoDeEmpresas);
		}
		{
			JButton btnCadastrarEmpresas = new JButton("Cadastrar Empresas");
			btnCadastrarEmpresas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TelaCadastrarEmpresa telaCadastrarEmpresa = new TelaCadastrarEmpresa();
					telaCadastrarEmpresa.setVisible(true);
				}
			});
			btnCadastrarEmpresas.setFont(new Font("Arial", Font.PLAIN, 12));
			btnCadastrarEmpresas.setBounds(99, 76, 154, 33);
			contentPanel.add(btnCadastrarEmpresas);
		}
		{
			JButton btnAtualizarEmpresas = new JButton("Atualizar Empresas");
			btnAtualizarEmpresas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TelaAtualizaEmpresa telaAtualizaEmpresa = new TelaAtualizaEmpresa();
					telaAtualizaEmpresa.setVisible(true);
				}
			});
			btnAtualizarEmpresas.setFont(new Font("Arial", Font.PLAIN, 12));
			btnAtualizarEmpresas.setBounds(99, 133, 154, 33);
			contentPanel.add(btnAtualizarEmpresas);
		}
		{
			JButton btnDeletarEmpresas = new JButton("Deletar Empresas");
			btnDeletarEmpresas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TelaDeletarEmpresa telaDeletarEmpresa = new TelaDeletarEmpresa();
					telaDeletarEmpresa.setVisible(true);
				}
			});
			btnDeletarEmpresas.setFont(new Font("Arial", Font.PLAIN, 12));
			btnDeletarEmpresas.setBounds(99, 192, 154, 33);
			contentPanel.add(btnDeletarEmpresas);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 43, 333, 194);
			contentPanel.add(separator);
		}
	}

}
