package com.websystique.springsecurity.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springsecurity.model.Commentaire;
import com.websystique.springsecurity.model.Sujet;

@Repository("commentaireDao")
public class CommentaireDaoImpl extends AbstractDao<Integer, Commentaire> implements CommentaireDao{

	@Override
	public void save(Commentaire commentaire) {
		persist(commentaire);
	}

	@Override
	public void deleteById(Integer comment_id) {
		Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", comment_id));
        Commentaire comment = (Commentaire) crit.uniqueResult();
        delete(comment);
	}

}
