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
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedHashSet;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;

public class TelaDeletarEmpresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNomeEmpresa;
	private JTextField txtQtdNotasEmitidas;
	private JTextField txtQtdDebitoPendente;
	private JComboBox  cbEmpresas;
	private ControllerView controllerView;
	private LinkedHashSet<Empresa> empresas;

	
	public static void main(String[] args) {
		try {
			TelaDeletarEmpresa dialog = new TelaDeletarEmpresa();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaDeletarEmpresa() {
		setTitle("Deletar");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaDeletarEmpresa.class.getResource("/View/Icone.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				controllerView = new ControllerView();
				empresas = new LinkedHashSet<Empresa>();
				empresas = controllerView.carregaEmpresas(0);
				
				for (Empresa empresa : empresas) {
					cbEmpresas.addItem(empresa);
				}
			}
		});
		setBounds(100, 100, 450, 307);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblDeletarEmpresa = new JLabel("Deletar Empresa");
		lblDeletarEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeletarEmpresa.setFont(new Font("Arial", Font.BOLD, 22));
		lblDeletarEmpresa.setBounds(10, 10, 416, 29);
		contentPanel.add(lblDeletarEmpresa);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 49, 416, 13);
		contentPanel.add(separator);
		
		JLabel lblSelecoineAEmpresa = new JLabel("Selecoine a empresa para deletar:");
		lblSelecoineAEmpresa.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSelecoineAEmpresa.setBounds(10, 84, 198, 13);
		contentPanel.add(lblSelecoineAEmpresa);
		
		cbEmpresas = new JComboBox();
		cbEmpresas.setFont(new Font("Arial", Font.PLAIN, 12));
		cbEmpresas.setModel(new DefaultComboBoxModel(new String[] {"Selecione..."}));
		cbEmpresas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Empresa empresa = new Empresa();
				ControllerView controllerView = new ControllerView();
				if (cbEmpresas.getSelectedIndex()!=0) {
					empresa = controllerView.carregaUmaEmpresa(((Empresa)cbEmpresas.getSelectedItem()).getID());
					txtNomeEmpresa.setText(empresa.getNome());
					txtQtdDebitoPendente.setText(Integer.toString(empresa.getQntdDebitoPendente()));
					txtQtdNotasEmitidas.setText(Integer.toString(empresa.getQtdNotasEmitidas()));
				}				
			}
		});
		cbEmpresas.setBounds(234, 80, 162, 21);
		contentPanel.add(cbEmpresas);
		
		JLabel label = new JLabel("Nome da Empesa");
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setBounds(10, 134, 159, 13);
		contentPanel.add(label);
		
		txtNomeEmpresa = new JTextField();
		txtNomeEmpresa.setEditable(false);
		txtNomeEmpresa.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNomeEmpresa.setColumns(10);
		txtNomeEmpresa.setBounds(234, 134, 162, 19);
		contentPanel.add(txtNomeEmpresa);
		
		txtQtdNotasEmitidas = new JTextField();
		txtQtdNotasEmitidas.setFont(new Font("Arial", Font.PLAIN, 12));
		txtQtdNotasEmitidas.setEditable(false);
		txtQtdNotasEmitidas.setColumns(10);
		txtQtdNotasEmitidas.setBounds(234, 157, 162, 19);
		contentPanel.add(txtQtdNotasEmitidas);
		
		txtQtdDebitoPendente = new JTextField();
		txtQtdDebitoPendente.setFont(new Font("Arial", Font.PLAIN, 12));
		txtQtdDebitoPendente.setEditable(false);
		txtQtdDebitoPendente.setColumns(10);
		txtQtdDebitoPendente.setBounds(234, 180, 162, 19);
		contentPanel.add(txtQtdDebitoPendente);
		
		JLabel label_1 = new JLabel("Quantidade de débitos pendentes");
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(10, 180, 194, 13);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("Quantidade de notas emitidas");
		label_2.setFont(new Font("Arial", Font.PLAIN, 12));
		label_2.setBounds(10, 157, 182, 13);
		contentPanel.add(label_2);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empresa empresa = new Empresa();
				ControllerView controllerView = new ControllerView();
				empresa = (Empresa) cbEmpresas.getSelectedItem();
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "", JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					controllerView.deletaEmpresa(empresa);
					JOptionPane.showMessageDialog(null, "Empresa removida com sucesso");
					cbEmpresas.remove(cbEmpresas.getSelectedIndex());
					txtNomeEmpresa.setText("");
					txtQtdDebitoPendente.setText("");
					txtQtdNotasEmitidas.setText("");
				}
			}
		});
		btnDeletar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnDeletar.setBounds(174, 222, 85, 31);
		contentPanel.add(btnDeletar);
	}
}
