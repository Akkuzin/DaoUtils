package aaa.utils.dao.hibernate;

import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Restrictions;

import java.util.stream.Collector;

import static org.hibernate.criterion.Restrictions.conjunction;
import static org.hibernate.criterion.Restrictions.disjunction;

public class CriterionUtils {

	public static Collector<Criterion, Disjunction, Disjunction> toDisjunction() {
		return Collector.of(Restrictions::disjunction,
							Junction::add,
							(d1, d2) -> (Disjunction) disjunction().add(d1).add(d2));
	}

	public static Collector<Criterion, Conjunction, Conjunction> toConjunction() {
		return Collector.of(Restrictions::conjunction,
							Junction::add,
							(d1, d2) -> (Conjunction) conjunction().add(d1).add(d2));
	}
}
