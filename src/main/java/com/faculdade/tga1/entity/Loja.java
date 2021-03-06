package com.faculdade.tga1.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

/**
 * Trabalho - GA1
 * Banco de Dados II - 2014/1
 * Gilberto Irajá Müller
 *
 * Integrantes:
 *      Paulo Grabin - plgrabin@gmail.com
 *      Iuri Andreazza - iuri.andreazza@gmail.com
 *      Talita Audibert - tali.audibert@gmail.com
 *      Eduardo Pereira da Silva - eduardobursa@gmail.com
 *
 */
@Entity
@SequenceGenerator(name = "seq_id_Loja", sequenceName = "seq_id_Loja")
public class Loja extends AbstractEntity<Long> {

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    @Temporal(TemporalType.DATE)
    private Date dataAbertura;

    @Getter
    @Setter
    private int nroFuncionario;

    @Getter
    @Setter
    @OneToMany(mappedBy = "loja", cascade = CascadeType.ALL)
    private List<Departamento> departamentos;

    @Getter
    @Setter
    @OneToMany(mappedBy = "loja", cascade = CascadeType.ALL)
    private List<EstoqueGradeItem> estoqueGradeItem;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private Empresa empresa;
    
    public void addDepartamento(Departamento d) {
		if(departamentos == null)
			departamentos = new ArrayList<Departamento>();

		departamentos.add(d);
	}
    
	public void addEstoqueGradeItem(EstoqueGradeItem egi) {
		if(estoqueGradeItem == null)
			estoqueGradeItem = new ArrayList<EstoqueGradeItem>();

		estoqueGradeItem.add(egi);
	}
}
