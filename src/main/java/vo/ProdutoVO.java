package vo;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import entity.Produto;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.io.Serializable;

@Data
//@JsonPropertyOrder
public class ProdutoVO implements Serializable {

    private Long id;
    private String nome;
    private Integer estoque;
    private Double preco;

    public static ProdutoVO create(Produto produto){
        return new ModelMapper().map(produto,ProdutoVO.class);
    }
}
