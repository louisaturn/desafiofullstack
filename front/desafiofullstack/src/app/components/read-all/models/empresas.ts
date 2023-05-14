import { Fornecedor } from "./fornecedores";

export interface Empresa{
    cnpj: String,
    nomeFantasia: String,
    cep: String,
    fornecedores: Fornecedor[]
}
