package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListStudent;;

public class ListStudentHelper {
	static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Week5ProjKalpana");



	public void insertStudentName(ListStudent ls) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ls);
		em.getTransaction().commit();
		em.close();

	}

	public List<ListStudent> showAllstudentNames(){
		EntityManager em = emFactory.createEntityManager();
		List<ListStudent> allStudents = em.createQuery("SELECT i FROM ListStudent i").getResultList();
		return allStudents;	
	}

	public void deleteStudent(ListStudent toDelete) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		//placeholder
		TypedQuery<ListStudent> typedQuery = em.createQuery("select ls from ListStudent ls where ls.college =:selectedCollege and ls.studentName =:selectedStudentName", ListStudent.class);

		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedCollege",toDelete.getCollege()); 
		typedQuery.setParameter("selectedStudentName", toDelete.getStudentName()); 

		//we only want one result
		typedQuery.setMaxResults(1);

		//get the result and save it into a new list item
		ListStudent result = typedQuery.getSingleResult();

		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}




	public List<ListStudent> searchForstudentNameByCollege(String college) {
		EntityManager em = emFactory.createEntityManager();
		TypedQuery<ListStudent> typedQuery  = em.createQuery("SELECT ls FROM ListStudent ls where ls.college =:selectedCollege",ListStudent.class);

		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedCollege",college);

		//get the result and save it into a new list item
		List<ListStudent> result = typedQuery.getResultList();
		return result;
	}

	public List<ListStudent> searchForstudentNameByStudentName(String studentName) {
		EntityManager em = emFactory.createEntityManager();
		TypedQuery<ListStudent> typedQuery  = em.createQuery("SELECT ls FROM ListStudent ls where ls.student =:selectedStudentName",ListStudent.class);

		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedStudentName",studentName);

		//get the result and save it into a new list item
		List<ListStudent> result = typedQuery.getResultList();
		return result;
	}

	public ListStudent searchForStudentNameById(int idToEdit) {
		EntityManager em = emFactory.createEntityManager();
		TypedQuery<ListStudent> typedQuery  = em.createQuery("SELECT ls FROM ListStudent ls where ls.id =:selectedId",ListStudent.class);

		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId",idToEdit);

		//we only want one result
		typedQuery.setMaxResults(1);

		//get the result and save it into a new list item
		ListStudent result = typedQuery.getSingleResult();

		em.close();

		return result;
	}



	public void updateStudentName(ListStudent toEdit) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();

		TypedQuery<ListStudent> typedQuery = em.createQuery("UPDATE ListStudent ls SET ls.college =:selectedCollege, ls.studentName =:selectedStudentName where ls.id =:selectedId ", ListStudent.class);
		typedQuery.setParameter("selectedCollege", toEdit.getCollege());  
		typedQuery.setParameter("selectedStudentName", toEdit.getStudentName()); 
		typedQuery.setParameter("selectedId", toEdit.getId());

		int rowUpdate = typedQuery.executeUpdate();
		em.getTransaction().commit();
		em.close();

	}

	public void cleanUp() {
		emFactory.close();

	}
}

