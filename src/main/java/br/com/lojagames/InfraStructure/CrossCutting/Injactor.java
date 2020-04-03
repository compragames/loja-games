package br.com.lojagames.InfraStructure.CrossCutting;

import br.com.lojagames.Application.IService.IClienteServices;
import br.com.lojagames.Application.IService.IFuncionarioServices;
import br.com.lojagames.Application.IService.IProdutoServices;
import br.com.lojagames.Application.IService.IUserServices;
import br.com.lojagames.Application.Model.ClienteModel;
import br.com.lojagames.Application.Model.FuncionarioModel;
import br.com.lojagames.Application.Model.ProdutoModel;
import br.com.lojagames.Application.Services.ClienteServices;
import br.com.lojagames.Application.Services.FuncionarioServices;
import br.com.lojagames.Application.Services.ProdutoServices;
import br.com.lojagames.Application.Services.UserServices;
import br.com.lojagames.Domain.Entity.ClienteEntity;
import br.com.lojagames.Domain.Entity.FuncionarioEntity;
import br.com.lojagames.Domain.Entity.ProdutoEntity;
import br.com.lojagames.Domain.Entity.UserEntity;
import br.com.lojagames.Domain.Interfaces.IFuncionarioRepository;
import br.com.lojagames.InfraStructure.Data.ProdutoRepository;
import br.com.lojagames.Domain.Interfaces.IProdutoRepository;
import br.com.lojagames.Domain.Interfaces.IUserRepository;
import br.com.lojagames.InfraStructure.Data.ClienteRepository;
import br.com.lojagames.InfraStructure.Data.FuncionarioRepository;
import br.com.lojagames.InfraStructure.Data.UserRepository;
import br.com.lojasgames.Domain.Interfaces.IClienteRepository;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

/**
 *
 * @author Victor
 */
public class Injactor {

    public static void services(AbstractBinder abstractBinder) {
        abstractBinder.bind(ProdutoServices.class).to(IProdutoServices.class);
        abstractBinder.bind(ClienteServices.class).to(IClienteServices.class);
        abstractBinder.bind(FuncionarioServices.class).to(IFuncionarioServices.class);
        abstractBinder.bind(UserServices.class).to(IUserServices.class);
        
    }

    public static void repository(AbstractBinder abstractBinder) {
        abstractBinder.bind(ProdutoRepository.class).to(IProdutoRepository.class);
        abstractBinder.bind(ClienteRepository.class).to(IClienteRepository.class);
        abstractBinder.bind(FuncionarioRepository.class).to(IFuncionarioRepository.class);        
        abstractBinder.bind(UserRepository.class).to(IUserRepository.class);

    }

    public static void model(AbstractBinder abstractBinder) {

        abstractBinder.bind(ProdutoModel.class).to(ProdutoModel.class);
        abstractBinder.bind(ClienteModel.class).to(ClienteModel.class);
        abstractBinder.bind(FuncionarioModel.class).to(FuncionarioModel.class);

    }

    public static void entity(AbstractBinder abstractBinder) {

        abstractBinder.bind(ProdutoEntity.class).to(ProdutoEntity.class);
        abstractBinder.bind(ClienteEntity.class).to(ClienteEntity.class);
        abstractBinder.bind(FuncionarioEntity.class).to(FuncionarioEntity.class);
        abstractBinder.bind(UserEntity.class).to(UserEntity.class);
        

    }
}
