package br.com.lojagames.InfraStructure.CrossCutting;

import br.com.lojagames.Application.IService.IProdutoServices;
import br.com.lojagames.Application.Model.ProdutoModel;
import br.com.lojagames.Application.Services.ProdutoServices;
import br.com.lojagames.Domain.Entity.ProdutoEntity;
import br.com.lojagames.InfraStructure.Data.ProdutoRepository;
import br.com.lojagames.Domain.Interfaces.IProdutoRepository;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

/**
 *
 * @author Victor
 */
public class Injactor {

    public static void services(AbstractBinder abstractBinder) {
        abstractBinder.bind(ProdutoServices.class).to(IProdutoServices.class);

    }

    public static void repository(AbstractBinder abstractBinder) {
        abstractBinder.bind(ProdutoRepository.class).to(IProdutoRepository.class);

    }

    public static void model(AbstractBinder abstractBinder) {

        abstractBinder.bind(ProdutoModel.class).to(ProdutoModel.class);

    }

    public static void entity(AbstractBinder abstractBinder) {

        abstractBinder.bind(ProdutoEntity.class).to(ProdutoEntity.class);

    }
}
