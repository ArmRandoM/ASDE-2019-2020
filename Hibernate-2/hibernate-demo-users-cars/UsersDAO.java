package it.unical.asde.hibernatedemo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.unical.asde.hibernatedemo.model.User;

/* In this case we added two additional methods by following the naming convention.
 * As reference for the naming conventions we can use the documentation we are using
 * the Spring Data JPA naming conventions.
 */
public interface UsersDAO extends CrudRepository<User, String>{

	/* In this case we want to get the user given the car brand. The CrudRepository 
	 * can only return tipically user by default or list of users because this is 
	 * is a CrudRepository for the User class.
	 */
	List<User> findUsersByUserCarsBrand(String string);
	
	
	/* Here we can find how we can specify some manual queries on the methods of 
	 * the DAO. If we are using the @Query annotation we can write the query, but
	 * be aware that the query is not written in SQL, the query is written in a 
	 * language that is named HQL - HIBERNATE Query Language - or sometimes it is
	 * referred as JPQL -Java Persistence Query Language.The main difference res-
	 * pect to SQL is that we are referring to the classes and to the operations
	 * that we are using in Java. We have the dot notation and we can go through 
	 * the relation using JOIN -we can write for example user.address.city- we 
	 * can refer to the name of the classes, to the name of the private fields
	 * even if the real name of the column or the table in the database is diffe-
	 * rent. 
	 * In the query we find a particular keyword that is join fetch, basically 
	 * when we are selecting elements, entity from the database sometimes we don't
	 * have all the private fields initialized, in particular if we have a collec-
	 * tion for example it is not initialized, the element are loaded in a lazy way
	 * (Lazy Loading). This is important! Because if we cascade all the loading so-
	 * metimes we can endup loading the entire database. For example, let say that
	 * we have the university domain in which we have all the university in Italy
	 * and a university has all the list of students maybe we are interested in
	 * finding all the university of Calabria, so the university has a region, 
	 * we are interested in loading all the universities and than do some 
	 * operations on the universities but we are not using the students, in this 
	 * case we prefer Lazy Loading! We dont' want to load also the list of the
	 * students if we are not interested in.Lazy Loading is important because
	 * tipically we want to chose what we want to get from the database and 
	 * what we are not interested in.If we load the all entity it will cascade 
	 * a lot of loading from the database and we end up in loading more data 
	 * that the one that we really need.  
	 * Heavy data structures mostly collections or relations are not loaded by 
	 * default, so for the universities example, we can create an instance of 
	 * university and we don't load the student but if we want to load that ele-
	 * ment explicitly we have to perform some extra stuff (like in this case).
	 * Here when we select the user we specify that we also want to fetch the 
	 * phone numbers, if we have a collection inside a class and we want to load
	 * also the collection we write "join fetch" followed by the name of the col-
	 * lection or by the name of the relation and it will load it as well.
	 */
	@Query("FROM User u join fetch u.phoneNumbers WHERE u.username=:id")
	User findByIdWithPhoneNumbers(String id);
	
	
}
