package Model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EmpresasDAOJSON {

	private String nomeArquivoJSON = null;

	public EmpresasDAOJSON(String nomeArquivoJSON) {
		super();
		this.nomeArquivoJSON = nomeArquivoJSON;
	}
	
	public EmpresasDAOJSON() {
		super();
	}
	
	

	public void setNomeArquivoJSON(String nomeArquivoJSON) {
		this.nomeArquivoJSON = nomeArquivoJSON;
	}



	@SuppressWarnings("rawtypes")
	public ArrayList<Empresa> getEmpresas() {
		ArrayList<Empresa> listaEmpresa = new ArrayList<Empresa>();
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader(nomeArquivoJSON)) {

			// Ler o arquivo JSON
			Object obj = jsonParser.parse(reader);
			JSONArray arrayEmpresasJSON = (JSONArray) ((JSONObject) obj).get("empresas");
			Iterator iterator = arrayEmpresasJSON.iterator();
			while (iterator.hasNext()) {
				JSONObject objetoEmpresaJSON = (JSONObject) iterator.next();
				// Atribuindo dados do Array para as variáveis
				int idEmpresa = ((Long) objetoEmpresaJSON.get("ID")).intValue();
				int qntdDebitosPendentes = ((Long) objetoEmpresaJSON.get("qntdDebidoPendente")).intValue();
				int qntdNotasEmitidas = ((Long) objetoEmpresaJSON.get("qntdNotasEmitidas")).intValue();

				Empresa empresa = new Empresa();
				// setando os dados das variáveis para a empresa
				empresa.setID(idEmpresa);
				empresa.setQntdDebitoPendente(qntdDebitosPendentes);
				empresa.setQtdNotasEmitidas(qntdNotasEmitidas);
				listaEmpresa.add(empresa);

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaEmpresa;
	}
}
