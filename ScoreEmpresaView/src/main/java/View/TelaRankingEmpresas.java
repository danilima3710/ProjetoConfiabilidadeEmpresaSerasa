package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.border.MatteBorder;

import Controller.ControllerView;
import Model.Empresa;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedHashSet;
import java.awt.List;
import java.awt.Scrollbar;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaRankingEmpresas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DefaultListModel modelo;
	private JList listOrdenado;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaRankingEmpresas dialog = new TelaRankingEmpresas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaRankingEmpresas() {
		setFont(new Font("Arial", Font.PLAIN, 12));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ControllerView controllerView = new ControllerView();
				LinkedHashSet<Empresa> empresas = new LinkedHashSet<Empresa>();
				empresas = controllerView.carregaEmpresas(0);
				modelo = new DefaultListModel();
				listOrdenado.setModel(modelo);
				for (Empresa empresa : empresas) {
					modelo.addElement(empresa.getNome());
				}
				listOrdenado.setModel(modelo);
			}
		});
		setResizable(false);
		setTitle("Ranking das Empresas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaRankingEmpresas.class.getResource("/View/Icone.png")));
		setBounds(100, 100, 451, 359);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblRankingDasEmpresas = new JLabel("Ranking das Empresas");
		lblRankingDasEmpresas.setHorizontalAlignment(SwingConstants.CENTER);
		lblRankingDasEmpresas.setFont(new Font("Arial", Font.BOLD, 22));
		lblRankingDasEmpresas.setBounds(10, 10, 414, 31);
		contentPanel.add(lblRankingDasEmpresas);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 51, 414, 17);
		contentPanel.add(separator);
		
		JLabel lblSelecioneOTipo = new JLabel("Selecione o tipo de ordenação");
		lblSelecioneOTipo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSelecioneOTipo.setBounds(10, 78, 178, 13);
		contentPanel.add(lblSelecioneOTipo);
		
		JComboBox cbTipoOrdenacao = new JComboBox();
		cbTipoOrdenacao.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ControllerView controllerView = new ControllerView();
				LinkedHashSet<Empresa> empresas = new LinkedHashSet<Empresa>();
				modelo = new DefaultListModel();
				modelo.clear();

				if(cbTipoOrdenacao.getSelectedIndex()==1) {
					empresas = controllerView.carregaEmpresas(1);
					for (Empresa empresa : empresas) {
						modelo.addElement("Empresa: " + empresa.getNome() + " || Confiabilidade: " + Integer.toString(empresa.getScoreEmpresa()) + "%");
					}
				}else {
					if(cbTipoOrdenacao.getSelectedIndex()==2) {
						empresas = controllerView.carregaEmpresas(2);
						for (Empresa empresa : empresas) {
							modelo.addElement("Empresa: " + empresa.getNome() + " || Quantidade de nota(s) emitida(s): " + Integer.toString(empresa.getQtdNotasEmitidas()));
						}
					}else {
						if(cbTipoOrdenacao.getSelectedIndex()==3) {
							empresas = controllerView.carregaEmpresas(3);
							for (Empresa empresa : empresas) {
								modelo.addElement("Empresa: " + empresa.getNome() + " || Quantidade de débito(s) pendente(s): " + Integer.toString(empresa.getQntdDebitoPendente()));
							}
						}else {
							if(cbTipoOrdenacao.getSelectedIndex()==4) {
								empresas = controllerView.carregaEmpresas(4);
								for (Empresa empresa : empresas) {
									modelo.addElement(empresa.getNome());
								}
							}
						}
					}
				}
				
				listOrdenado.setModel(modelo);
			}
		});
		cbTipoOrdenacao.setFont(new Font("Arial", Font.PLAIN, 12));
		cbTipoOrdenacao.setModel(new DefaultComboBoxModel(new String[] {"Selecione...", "1- Confiabilidade", "2- Quantidade de Notas Emitidas", "3- Quantidade de Débitos Pendentes", "4- Ordem de Cadastro das Empresas"}));
		cbTipoOrdenacao.setSelectedIndex(0);
		cbTipoOrdenacao.setBounds(186, 74, 238, 21);
		contentPanel.add(cbTipoOrdenacao);
		
		listOrdenado = new JList();
		listOrdenado.setVisibleRowCount(15);
		listOrdenado.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		listOrdenado.setBounds(10, 112, 414, 183);
		contentPanel.add(listOrdenado);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 101, 427, 2);
		contentPanel.add(separator_1);
	}
}
