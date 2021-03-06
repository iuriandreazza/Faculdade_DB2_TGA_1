package com.faculdade.tga1.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

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
@SequenceGenerator(name = "seq_id_Cor", sequenceName = "seq_id_Cor")
public class Cor extends AbstractEntity<Long> {

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    @OneToMany(mappedBy = "cor", cascade = CascadeType.ALL)
    private List<GradeItem> gradeItem;
    
	public void addGradeItem(GradeItem p) {
		if(gradeItem == null)
			gradeItem = new ArrayList<GradeItem>();

		gradeItem.add(p);
	}
}
