package Model;

public class Cliente {

    private String nome;
    private String senha;
    private String documento;
    private String tipoDocumento;
    private String sexo;

    public Cliente(
            String nome,
            String senha,
            String documento,
            String tipoDocumento,
            String sexo
    ) {

        // VALIDAÇÕES
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException(
                    "O nome é obrigatório!"
            );
        }

        if (senha == null || senha.isBlank()) {
            throw new IllegalArgumentException(
                    "A senha é obrigatória!"
            );
        }

        if (documento == null || documento.isBlank()) {
            throw new IllegalArgumentException(
                    "O documento é obrigatório!"
            );
        }

        if (sexo == null || sexo.isBlank()) {
            throw new IllegalArgumentException(
                    "Selecione um sexo!"
            );
        }


        this.nome = nome;
        this.senha = senha;
        this.documento = documento;
        this.tipoDocumento = tipoDocumento;
        this.sexo = sexo;
    }


    public String getNome() {
        return nome;
    }


    public String getDocumento() {
        return documento;
    }


    public String getTipoDocumento() {
        return tipoDocumento;
    }


    public String getSexo() {
        return sexo;
    }
}