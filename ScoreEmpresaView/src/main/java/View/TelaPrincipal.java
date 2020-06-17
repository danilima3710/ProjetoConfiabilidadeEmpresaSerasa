package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ControllerView;
import Model.DataBaseProvider;
import Model.Empresa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Toolkit;

public class TelaPrincipal extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		DataBaseProvider baseProvider = new DataBaseProvider();
		baseProvider.conectDataBase();
		TelaPrincipal frame = new TelaPrincipal();
		frame.setVisible(true);
	}

	/**
	 * Create the dialog.
	 */
	public TelaPrincipal() {
		setTitle("Home");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/View/Icone.png")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblBemVindoAo = new JLabel("Bem vindo ao Company Classifier");
			lblBemVindoAo.setHorizontalAlignment(SwingConstants.CENTER);
			lblBemVindoAo.setFont(new Font("Arial", Font.BOLD, 22));
			lblBemVindoAo.setBounds(0, 10, 436, 25);
			contentPanel.add(lblBemVindoAo);
		}
		{
			JButton btnImportarArquivo = new JButton("Importar Arquivo");
			btnImportarArquivo.setFont(new Font("Arial", Font.PLAIN, 12));
			btnImportarArquivo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TelaImportarArquivo telaImportarArquivo = new TelaImportarArquivo();
					telaImportarArquivo.setVisible(true);
				}
			});
			btnImportarArquivo.setBounds(238, 88, 167, 48);
			contentPanel.add(btnImportarArquivo);
		}
		{
			JButton btnGerenciarEmpresas = new JButton("Gerenciar Empresas");
			btnGerenciarEmpresas.setFont(new Font("Arial", Font.PLAIN, 12));
			btnGerenciarEmpresas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TelaGerenciamentoEmpresas telaGerenciamentoEmpresas = new TelaGerenciamentoEmpresas();
					telaGerenciamentoEmpresas.setVisible(true);
				}
			});
			btnGerenciarEmpresas.setBounds(28, 88, 167, 48);
			contentPanel.add(btnGerenciarEmpresas);
		}

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 45, 416, 18);
		contentPanel.add(separator);

		JButton btnRankingDasEmpresas = new JButton("Ranking das Empresas");
		btnRankingDasEmpresas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRankingEmpresas telaRankingEmpresas = new TelaRankingEmpresas();
				telaRankingEmpresas.setVisible(true);
			}
		});
		btnRankingDasEmpresas.setFont(new Font("Arial", Font.PLAIN, 12));
		btnRankingDasEmpresas.setBounds(28, 173, 167, 48);
		contentPanel.add(btnRankingDasEmpresas);

		JButton btnCalcularDeConfiabilidade = new JButton("Calcular a Confiabilidade");
		btnCalcularDeConfiabilidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confiabilidade;
				ControllerView controllerView = new ControllerView();
				LinkedHashSet<Empresa> empresas = new LinkedHashSet<Empresa>();
				empresas = controllerView.carregaEmpresas(0);
				
				for (Empresa empresa : empresas) {
					empresa.setScoreEmpresa(controllerView.calcularRanking(empresa));
					controllerView.atualizaEmpresa(empresa);
					confiabilidade = empresa.getScoreEmpresa();
				}
				JOptionPane.showMessageDialog(null, "Confiabilidade calculado e atualizado com sucesso");
			}
		});
		btnCalcularDeConfiabilidade.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCalcularDeConfiabilidade.setBounds(238, 174, 167, 46);
		contentPanel.add(btnCalcularDeConfiabilidade);
	}
}
