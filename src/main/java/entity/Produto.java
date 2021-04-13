package entity;

import lombok.Data;
import org.modelmapper.ModelMapper;
import vo.ProdutoVO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer estoque;
    private Double preco;

    public static Produto create(ProdutoVO produtoVO){
        return new ModelMapper().map(produtoVO,Produto.class);
    }
}
