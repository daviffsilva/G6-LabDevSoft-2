
# Descrição das Histórias de Usuário - Sistema de Aluguel de Automóveis

# Cadastro e Acesso ao Sistema

## Cliente:

**Como um cliente**, eu quero poder me cadastrar no sistema com meus dados pessoais, para que eu possa acessar e utilizar o sistema de pedidos de aluguel.
   - **Critérios de Aceitação**:
     - O sistema deve permitir o cadastro prévio de clientes.
     - O cadastro só será finalizado se todos os campos obrigatórios forem preenchidos corretamente.
     - O sistema deve enviar um e-mail de confirmação para o cliente após o cadastro.

## Agente:

 **Como um agente**, eu quero me cadastrar no sistema como uma entidade, para poder gerenciar e avaliar os pedidos de aluguel dos clientes.
   - **Critérios de Aceitação**:
     - O cadastro deve solicitar nome da empresa, CNPJ, e outras informações relevantes.
     - O agente só poderá acessar o sistema após aprovação do administrador.

---

# Gerenciamento de Pedidos de Aluguel

## Cliente:

**Como um cliente**, eu quero poder criar um pedido de aluguel para um automóvel, fornecendo as informações necessárias, para que eu possa iniciar o processo de aluguel.
   - **Critérios de Aceitação**:
     - O sistema deve permitir a seleção de um automóvel disponível, com informações como marca, ano e modelo.
     - O cliente deve fornecer as informações de rendimento e empregador.
     - O pedido deve ser salvo no sistema para posterior avaliação.

**Como um cliente**, eu quero consultar meus pedidos de aluguel atuais e passados, para acompanhar o status e histórico dos contratos.
   - **Critérios de Aceitação**:
     - O cliente pode visualizar o status de cada pedido.
     - Detalhes do automóvel e do contrato devem estar disponíveis para consulta.

**Como um cliente**, eu quero poder modificar um pedido de aluguel existente, antes da análise financeira, para corrigir qualquer erro ou alterar detalhes do contrato.
   - **Critérios de Aceitação**:
     - O sistema permite modificar pedidos enquanto estiverem com o status "em avaliação".
     - Notificações são enviadas ao cliente confirmando as modificações realizadas.

**Como um cliente**, eu quero cancelar um pedido de aluguel que não tenha sido ainda executado, para que eu possa desistir do processo sem penalidades.
   - **Critérios de Aceitação**:
     - O cliente só pode cancelar pedidos que ainda não foram aprovados ou finalizados.
     - O sistema confirma o cancelamento e atualiza o status do pedido.

---

# Análise Financeira e Avaliação de Pedidos

## Agente:

**Como um agente**, eu quero poder avaliar financeiramente os pedidos de aluguel de automóveis, para aprovar ou rejeitar o contrato com base nas informações financeiras do cliente.
   - **Critérios de Aceitação**:
     - O sistema deve exibir as informações financeiras do cliente e detalhes do automóvel.
     - O agente pode aprovar ou rejeitar o pedido com base na análise.

**Como um agente**, eu quero modificar os detalhes do pedido de aluguel, caso seja necessário ajustar o contrato ou as condições financeiras antes de aprová-lo.
   - **Critérios de Aceitação**:
     - O sistema permite que o agente faça alterações nas condições do pedido.
     - Notificações são enviadas ao cliente sobre as alterações feitas pelo agente.

---

# Contrato e Execução

## Cliente:

**Como um cliente**, eu quero que, após a aprovação do pedido, o contrato seja gerado automaticamente no sistema, para que eu possa finalizar o processo de aluguel.
   - **Critérios de Aceitação**:
     - O contrato deve incluir todos os detalhes do aluguel e as partes envolvidas.
     - O sistema permite que o cliente assine digitalmente o contrato.

**Como um cliente**, eu quero que o automóvel alugado seja registrado como propriedade minha, da empresa ou do banco, dependendo das condições do contrato, para assegurar a correta titularidade do veículo.
   - **Critérios de Aceitação**:
     - O sistema registra a propriedade do automóvel conforme o tipo de contrato.
     - A propriedade pode ser alterada caso o contrato inclua financiamento por parte de um banco.

---

# Infraestrutura do Sistema

## Administrador:

**Como administrador do sistema**, eu quero garantir que o servidor central esteja conectado aos computadores locais dos clientes e agentes através da Internet, para que todas as operações possam ser realizadas de forma remota.
   - **Critérios de Aceitação**:
     - O servidor central deve estar sempre disponível para acessos remotos.
     - Monitoramento constante para garantir conectividade com clientes e agentes.
    
## Desenvolvedor:

**Como desenvolvedor**, eu quero que o sistema seja subdividido em dois subsistemas, para otimizar o desenvolvimento e manutenção.
   - **Critérios de Aceitação**:
     - O subsistema de gestão de pedidos deve lidar com a lógica de negócios.
     - O subsistema de construção de páginas deve gerar as interfaces web dinamicamente para os usuários.
