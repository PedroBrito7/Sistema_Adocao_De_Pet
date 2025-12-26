# Camada: Service
O "cérebro" do sistema. Aqui ficam as **Regras de Negócio** e validações obrigatórias.

### Responsabilidades:
- Validar se o nome contém apenas letras (A-Z).
- Validar limites de peso (0.5kg a 60kg).
- Validar idade (máximo 20 anos) e converter meses para `0.x`.
- Lançar exceções caso as regras do Passo 3 sejam violadas.
- Aplicar a constante `NAO_INFORMADO` para campos vazios.
### BuscaPet Service 
- **Responsabilidade:**

- **validar se a pasta existe**

- **decidir se lista vazia é erro**

- **filtrar (ex: só DOG)**

- **transformar em Pet**

- **lançar exceção se não tiver nenhum**:
