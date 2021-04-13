package services;

import entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repository.ProdutoRepository;
import vo.ProdutoVO;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository=produtoRepository;
    }

    public ProdutoVO create(ProdutoVO produtoVO){
        ProdutoVO produtoVORetorno = ProdutoVO.create(produtoRepository.save(Produto.create(produtoVO)));
        return produtoVORetorno;
    }

   public Page<ProdutoVO> findAll(Pageable pageable){
        var page = produtoRepository.findAll(pageable);
        return page.map((this::convertToProdutoVO));
    }

    private ProdutoVO convertToProdutoVO(Produto produto){
        return ProdutoVO.create(produto);
    }


}
