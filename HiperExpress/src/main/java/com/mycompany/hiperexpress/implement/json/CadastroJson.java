package com.mycompany.hiperexpress.implement.json;

import com.mycompany.hiperexpress.Administrador;
import com.mycompany.hiperexpress.Cliente;
import com.mycompany.hiperexpress.Funcionario;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroJson {

    private static final String nomeDoArquivoAdm = "administradores.json";
    private static final String nomeDoArquivoFuncionario = "funcionarios.json";
    private static final String nomeDoArquivoCliente = "clientes.json";

    // CADASTRAR ADMINISTRADOR >>>>>>>>>>>>>>>
    public static void cadastrarNovoAdministrador(String nome, String senha, String cpf) {
        boolean cpfExistente = false;

        // Lê a lista de administradores do arquivo JSON
        List<Administrador> administradores = lerAdm();

        // Verifica se o CPF já está cadastrado
        for (Administrador administrador : administradores) {
            if (administrador.getCPF().equals(cpf)) {
                cpfExistente = true;
                break;
            }
        }

        if (cpfExistente) {
            System.out.println("Esse CPF já é Administrador do Sistema. Favor verificar.");
        } else {
            // Cria um novo administrador e o adiciona à lista
            Administrador novoAdministrador = new Administrador(nome, senha, cpf);
            administradores.add(novoAdministrador);
            System.out.println("Administrador cadastrado com Sucesso!");

            // Escreve a lista atualizada no arquivo JSON
            escreverAdm(administradores);
        }
    }

    @SuppressWarnings("unchecked")
    private static List<Administrador> lerAdm() {
        JSONArray jsonArray = ManipularJson.lerArquivoJson(nomeDoArquivoAdm);
        List<Administrador> administradores = new ArrayList<>();

        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            String nome = (String) jsonObject.get("nome");
            String senha = (String) jsonObject.get("senha");
            String cpf = (String) jsonObject.get("cpf");

            Administrador administrador = new Administrador(nome, senha, cpf);
            administradores.add(administrador);
        }

        return administradores;
    }

    @SuppressWarnings("unchecked")
    private static void escreverAdm(List<Administrador> administradores) {
        JSONArray jsonArray = new JSONArray();

        for (Administrador administrador : administradores) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("nome", administrador.getNome());
            jsonObject.put("senha", administrador.getSenha());
            jsonObject.put("cpf", administrador.getCPF());

            jsonArray.add(jsonObject);
        }

        ManipularJson.escreverParaArquivo(jsonArray, nomeDoArquivoAdm);
    }

    // CADASTRAR FUNCIONARIO >>>>>>>>>>>>>>>
    public static void cadastrarNovoFuncionario(String nome, String senha, String cpf, String cargo) {
        boolean cpfExistente = false;

        // Lê a lista de funcionários do arquivo JSON
        List<Funcionario> funcionarios = lerArquivoFunc();

        // Verifica se o CPF já está cadastrado
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCPF().equals(cpf)) {
                cpfExistente = true;
                break;
            }
        }

        if (cpfExistente) {
            System.out.println("Esse CPF já é funcionário do HiperExpress. Favor verificar.");
        } else {
            // Cria um novo funcionário e o adiciona à lista
            Funcionario novoFuncionario = new Funcionario(nome, senha, cpf, cargo);
            funcionarios.add(novoFuncionario);
            System.out.println("Funcionário cadastrado com Sucesso!");

            // Escreve a lista atualizada no arquivo JSON
            escreverArquivoFunc(funcionarios);
        }
    }

    private static List<Funcionario> lerArquivoFunc() {
        List<Funcionario> funcionarios = new ArrayList<>();

        try (FileReader arquivo = new FileReader(nomeDoArquivoFuncionario)) {
            JSONArray jsonArray = (JSONArray) new org.json.simple.parser.JSONParser().parse(arquivo);

            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                String nome = (String) jsonObject.get("nome");
                String senha = (String) jsonObject.get("senha");
                String cpf = (String) jsonObject.get("cpf");
                String cargo = (String) jsonObject.get("cargo");

                Funcionario funcionario = new Funcionario(nome, senha, cpf, cargo);
                funcionarios.add(funcionario);
            }

        } catch (IOException | org.json.simple.parser.ParseException e) {
            System.out.println("Erro ao ler o arquivo JSON: " + e.getMessage());
        }

        return funcionarios;
    }

    private static void escreverArquivoFunc(List<Funcionario> funcionarios) {
        JSONArray jsonArray = new JSONArray();

        for (Funcionario funcionario : funcionarios) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("nome", funcionario.getNome());
            jsonObject.put("senha", funcionario.getSenha());
            jsonObject.put("cpf", funcionario.getCPF());
            jsonObject.put("cargo", funcionario.getCargo());

            jsonArray.add(jsonObject);
        }

        try (FileWriter arquivo = new FileWriter(nomeDoArquivoFuncionario)) {
            arquivo.write(jsonArray.toJSONString());
            arquivo.flush();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo JSON: " + e.getMessage());
        }
    }

    // CADASTRO DE CLIENTES >>>>>>>>>>>>>>>
    public static void cadastrarNovoCliente(Cliente novoCliente) {
        boolean cpfExiste = false;

        // Lê a lista de clientes do arquivo JSON
        List<Cliente> clientes = lerArquivoCliente();

        // Verifica se o CPF já está cadastrado
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(novoCliente.getCpf())) {
                cpfExiste = true;
                break;
            }
        }

        if (cpfExiste) {
            System.out.println("Esse CPF já é nosso cliente. Favor verificar.");
        } else {
            // Adiciona o novo cliente à lista
            clientes.add(novoCliente);
            System.out.println("Cliente cadastrado com sucesso!");

            // Escreve a lista atualizada no arquivo JSON
            escreverArquivoCliente(clientes);
        }
    }

    private static List<Cliente> lerArquivoCliente() {
        List<Cliente> clientes = new ArrayList<>();

        try (FileReader arquivo = new FileReader(nomeDoArquivoCliente)) {
            JSONArray jsonArray = (JSONArray) new org.json.simple.parser.JSONParser().parse(arquivo);

            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                String nome = (String) jsonObject.get("nome");
                String telefone = (String) jsonObject.get("telefone");
                String endereco = (String) jsonObject.get("endereco");
                String cpf = (String) jsonObject.get("cpf"); 

                Cliente cliente = new Cliente(nome, telefone, endereco, cpf);
                clientes.add(cliente);
            }

        } catch (IOException | org.json.simple.parser.ParseException e) {
            System.out.println("Erro ao ler o arquivo JSON: " + e.getMessage());
        }

        return clientes;
    }

    private static void escreverArquivoCliente(List<Cliente> clientes) {
        JSONArray jsonArray = new JSONArray();

        for (Cliente cliente : clientes) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("nome", cliente.getNome());
            jsonObject.put("telefone", cliente.getTelefone());
            jsonObject.put("endereco", cliente.getEndereco());
            jsonObject.put("cpf", cliente.getCpf());

            jsonArray.add(jsonObject);
        }

        try (FileWriter arquivo = new FileWriter(nomeDoArquivoCliente)) {
            arquivo.write(jsonArray.toJSONString());
            arquivo.flush();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo JSON: " + e.getMessage());
        }
    }

    //// REMOVER CADASTROS
    // REMOVER CLIENTE 
    public static void excluirCliente(String cpf) {
        // Lê a lista de clientes do arquivo JSON
        List<Cliente> clientes = lerArquivoCliente();

        // Verifica se o CPF está cadastrado
        Cliente clienteExclusao = null;
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                clienteExclusao = cliente;
                break;
            }
        }

        if (clienteExclusao != null) {
            // Remove o cliente da lista
            clientes.remove(clienteExclusao);
            System.out.println("Cliente removido com sucesso!");

            // Escreve a lista atualizada no arquivo JSON
            escreverArquivoCliente(clientes);
        } else {
            System.out.println("Cliente não encontrado no cadastro.");
        }
    }

    // REMOVER FUNCIONARIO
    public static void excluirFuncionario(String cpf) {
        // Lê a lista de funcionários do arquivo JSON
        List<Funcionario> funcionarios = lerArquivoFunc();

        // Verifica se o CPF está cadastrado
        Funcionario funcionarioExclusao = null;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCPF().equals(cpf)) {
                funcionarioExclusao = funcionario;
                break;
            }
        }

        if (funcionarioExclusao != null) {
            // Remove o funcionário da lista
            funcionarios.remove(funcionarioExclusao);
            System.out.println("Funcionário removido com sucesso!");

            // Escreve a lista atualizada no arquivo JSON
            escreverArquivoFunc(funcionarios);
        } else {
            System.out.println("Funcionário não encontrado no cadastro.");
        }
    }

    // REMOVER ADMINISTRADOR
    public static void excluirAdministrador(String cpf) {
        // Lê a lista de administradores do arquivo JSON
        List<Administrador> administradores = lerAdm();

        // Verifica se o CPF está cadastrado
        Administrador administradorExclusao = null;
        for (Administrador administrador : administradores) {
            if (administrador.getCPF().equals(cpf)) {
                administradorExclusao = administrador;
                break;
            }
        }

        if (administradorExclusao != null) {
            // Remove o administrador da lista
            administradores.remove(administradorExclusao);
            System.out.println("Administrador removido com sucesso!");

            // Escreve a lista atualizada no arquivo JSON
            escreverAdm(administradores);
        } else {
            System.out.println("Administrador não encontrado no cadastro.");
        }
    }

    //  LISTAR CADASTROS
    // ADMINISTRADOR 
    public static void listarAdministradores() {
        List<Administrador> administradores = lerAdm();

        if (administradores.isEmpty()) {
            System.out.println("Não há administradores cadastrados.");
        } else {
            System.out.println("Quantidade total: " + administradores.size() + " administradores cadastrados no sistema.");
            System.out.println("Lista de Administradores:");
            for (Administrador administrador : administradores) {
                System.out.println("Nome: " + administrador.getNome());
                System.out.println("CPF: " + administrador.getCPF());
                System.out.println("-------------------------");
            }
        }
    }

    //CLIENTE
    public static void listarClientes() {
        List<Cliente> clientes = lerArquivoCliente();

        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados.");
        } else {
            System.out.println("Quantidade total: " + clientes.size() + " clientes cadastrados no sistema.");
            System.out.println("Lista de Clientes:");
            for (Cliente cliente : clientes) {
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("CPF: " + cliente.getCpf());
                System.out.println("-------------------------");
            }
        }
    }

    // FUNCIONARIO
    public static void listarFuncionarios() {
        List<Funcionario> funcionarios = lerArquivoFunc();

        if (funcionarios.isEmpty()) {
            System.out.println("Não há funcionários cadastrados.");
        } else {
            System.out.println("Quantidade total: " + funcionarios.size() + " funcionários cadastrados no sistema.");
            System.out.println("Lista de Funcionários:");
            for (Funcionario funcionario : funcionarios) {
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("CPF: " + funcionario.getCPF());
                System.out.println("-------------------------");
            }
        }
    }

    //// EDITAR CADASTROS
    // EDITAR ADMINISTRADOR
    public static void editarDadosAdministrador() {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o CPF do Administrador: ");
        String cpf = input.nextLine();

        // Verifica se o administrador está cadastrado
        Administrador administradorParaEdicao = buscarAdministradorPorCPF(cpf);

        if (administradorParaEdicao != null) {
            System.out.println("Digite a senha do Administrador: ");
            String senhaDigitada = input.nextLine();

            // Verifica se a senha está correta
            if (administradorParaEdicao.getSenha().equals(senhaDigitada)) {
                System.out.println("Senha correta. Informe os novos dados:");

                System.out.printf("Novo Nome: ");
                String novoNome = input.nextLine();
                System.out.printf("Nova Senha: ");
                String novaSenha = input.nextLine();

                // Atualiza os dados do administrador
                administradorParaEdicao.setNome(novoNome);
                administradorParaEdicao.setSenha(novaSenha);

                // Atualiza o arquivo JSON com os novos dados
                atualizarAdministradorNoJson(administradorParaEdicao);

                System.out.println("Dados do administrador atualizados com sucesso.");
            } else {
                System.out.println("Senha incorreta. Não é possível editar os dados.");
            }
        } else {
            System.out.println("Administrador não encontrado no cadastro.");
        }
    }

// Função para buscar administrador por CPF
    private static Administrador buscarAdministradorPorCPF(String cpf) {
        List<Administrador> administradores = lerAdm();

        for (Administrador administrador : administradores) {
            if (administrador.getCPF().equals(cpf)) {
                return administrador;
            }
        }

        return null; // Retorna null se não encontrar o administrador com o CPF informado
    }

// Função para atualizar administrador no arquivo JSON
    private static void atualizarAdministradorNoJson(Administrador administradorAtualizado) {
        List<Administrador> administradores = lerAdm();

        for (int i = 0; i < administradores.size(); i++) {
            Administrador administrador = administradores.get(i);
            if (administrador.getCPF().equals(administradorAtualizado.getCPF())) {
                administradores.set(i, administradorAtualizado);
                escreverAdm(administradores);
                return;
            }
        }

        System.out.println("Erro ao atualizar administrador no arquivo JSON.");
    }

    // EDITAR FUNCIONARIO
    // Função para editar dados de funcionários
    public static void editarDadosFuncionario() {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o CPF do Administrador para confirmação: ");
        String cpfAdmin = input.nextLine();

        // Verifica se o administrador está cadastrado
        Administrador administradorConfirmacao = buscarAdministradorPorCPF(cpfAdmin);

        if (administradorConfirmacao != null) {
            System.out.println("Digite a senha do Administrador: ");
            String senhaDigitada = input.nextLine();

            // Verifica se a senha está correta
            if (administradorConfirmacao.getSenha().equals(senhaDigitada)) {
                System.out.println("Senha correta. Informe os dados do Funcionário a ser editado:");

                System.out.println("Digite o CPF do Funcionário: ");
                String cpf = input.nextLine();

                // Verifica se o funcionário está cadastrado
                Funcionario funcionarioParaEdicao = buscarFuncionarioPorCPF(cpf);

                if (funcionarioParaEdicao != null) {
                    System.out.println("Cpf encontrado. Informe os novos dados:");

                    System.out.printf("Novo Nome: ");
                    String novoNome = input.nextLine();
                    System.out.printf("Nova Senha: ");
                    String novaSenha = input.nextLine();
                    System.out.printf("Novo Cargo: ");
                    String novoCargo = input.nextLine();

                    // Atualiza os dados do funcionário
                    funcionarioParaEdicao.setNome(novoNome);
                    funcionarioParaEdicao.setSenha(novaSenha);
                    funcionarioParaEdicao.setCargo(novoCargo);

                    // Atualiza o arquivo JSON com os novos dados
                    atualizarFuncionarioNoJson(funcionarioParaEdicao);

                    System.out.println("Dados do funcionário atualizados com sucesso.");
                } else {
                    System.out.println("Funcionário não encontrado no cadastro.");
                }
            } else {
                System.out.println("CPF NAO ENCONTRADO!! Não é possível editar os dados do Funcionário.");
            }
        } else {
            System.out.println("Administrador não encontrado no cadastro.");
        }
    }
// Função para buscar funcionário por CPF

    private static Funcionario buscarFuncionarioPorCPF(String cpf) {
        List<Funcionario> funcionarios = lerArquivoFunc();

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCPF().equals(cpf)) {
                return funcionario;
            }
        }

        return null; // Retorna null se não encontrar o funcionário com o CPF informado
    }

// Função para atualizar funcionário no arquivo JSON
    private static void atualizarFuncionarioNoJson(Funcionario funcionarioAtualizado) {
        List<Funcionario> funcionarios = lerArquivoFunc();

        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario funcionario = funcionarios.get(i);
            if (funcionario.getCPF().equals(funcionarioAtualizado.getCPF())) {
                funcionarios.set(i, funcionarioAtualizado);
                escreverArquivoFunc(funcionarios);
                return;
            }
        }

        System.out.println("Erro ao atualizar funcionário no arquivo JSON.");
    }

    // EDITAR CLIENTE
    
    // Função para editar dados de clientes
    public static void editarDadosCliente() {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o CPF do Administrador para confirmação: ");
        String cpfAdmin = input.nextLine();

        // Verifica se o administrador está cadastrado
        Administrador administradorConfirmacao = buscarAdministradorPorCPF(cpfAdmin);

        if (administradorConfirmacao != null) {
            System.out.println("Digite a senha do Administrador: ");
            String senhaDigitada = input.nextLine();

            // Verifica se a senha está correta
            if (administradorConfirmacao.getSenha().equals(senhaDigitada)) {
                System.out.println("Senha correta. Informe os dados do Cliente a ser editado:");

                System.out.println("Digite o CPF do Cliente: ");
                String cpf = input.nextLine();

                // Verifica se o cliente está cadastrado
                Cliente clienteParaEdicao = buscarClientePorCPF(cpf);

                if (clienteParaEdicao != null) {
                    System.out.println("Cpf Encontrado. Informe os novos dados:");

                    System.out.printf("Novo Nome: ");
                    String novoNome = input.nextLine();
                    System.out.printf("Novo Telefone: ");
                    String novoTelefone = input.nextLine();
                    System.out.printf("Novo Endereço: ");
                    String novoEndereco = input.nextLine();

                    // Atualiza os dados do cliente
                    clienteParaEdicao.setNome(novoNome);
                    clienteParaEdicao.setTelefone(novoTelefone);
                    clienteParaEdicao.setEndereco(novoEndereco);

                    // Atualiza o arquivo JSON com os novos dados
                    atualizarClienteNoJson(clienteParaEdicao);

                    System.out.println("Dados do cliente atualizados com sucesso.");
                } else {
                    System.out.println("Cliente não encontrado no cadastro.");
                }
            } else {
                System.out.println("CPF NAO ENCONTRADO!!! Não é possível editar os dados do Cliente.");
            }
        } else {
            System.out.println("Administrador não encontrado no cadastro.");
        }
    }
// Função para buscar cliente por CPF

    private static Cliente buscarClientePorCPF(String cpf) {
        List<Cliente> clientes = lerArquivoCliente();

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }

        return null; // Retorna null se não encontrar o cliente com o CPF informado
    }

// Função para atualizar cliente no arquivo JSON
    private static void atualizarClienteNoJson(Cliente clienteAtualizado) {
        List<Cliente> clientes = lerArquivoCliente();

        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            if (cliente.getCpf().equals(clienteAtualizado.getCpf())) {
                clientes.set(i, clienteAtualizado);
                escreverArquivoCliente(clientes);
                return;
            }
        }

        System.out.println("Erro ao atualizar cliente no arquivo JSON.");
    }
}
