# Java les ORM

*Notes*

JPA(JAva Persistence API)  specification lié a la persistance des objets dans une db.
→ on utilise hibernate ici
→ Ce qu'on apprend donc en hibernate sera valide pour toutes les autres libraiires
JPA s'appuie sur les annotations pour faire le mapping ``Objet -> bdd``

```Java
/**
 * @Override
 */
```
Est aussi un exemple d'annotation pour "signaler" une surcharge.

## Architecture et besoins
- bdd relationnelle (ptet aussi noSql)
- un driver JDBC
- configuration xml de la connexion a la base (*datasource*)
- une classe ``JavaBean`` qui deviendra une **JPA Entity**
- un manager de l'ensemble des **JPA Entity** (entitymanager)

> Les classes doivent etre bien faites:  
* Respecte le principe d'encapsulation (getters & setters)
* Au moin le constructeur vide
* Classe implemente l'interface ``Serializable``

```java
@Entity
@Table(name="Utilisateurs") // How the object is named in the database

public class User implements Serializable {
	// my properties

	//Specify the attribute for the primary key (no auto_increment)
	@Id
	// @GeneratedValue ...
	private int id;
	private String name;
	private String firstname;

	// ... setters & getters ...
}
```

```java
@GeneratedValue(strategy=GenerationType.XXX)

```
| The constants proposed are : ||
| ---------------------------- |
| IDENTITY | The ``auto_increment`` is shared with all the tables |
| TABLE | Typical ``auto_increment`` |
| ... | ... |


| Other implementations ||
| -------------------- |
| @Transient | do not persist this attribute |
| @Lob or @Temporal | ... |

## Configuration
Fichier ``persistence.xml`` dans ``ressources/META-INF``

```xml
<persistence-unit name="primary"></persistence-unit>
```

```xml
<jta-datasource>java:jboss/datasources/app-DS</jta-datasource>
```

## Persistence
```java
public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Ticket t = new Ticket();
        t.setId(5L);
        t.setNom("1er essai");

        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        em.getTransaction().begin();

        em.persist(t);

        em.getTransaction().commit();
        em.close();
        PersistenceManager.INSTANCE.close();
    }
```

## Find
```java
// Find
EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

Ticket tFind = em.find(Ticket.class, 5L); // utilisable que avc cle primare

System.out.println(tFind);
```

## Remove
> Same than persist bu keyword is ``remove``

## JPQL
* Lanagage proche du **SQL** mais manipule des objets

Exemple:
```java
Query query = em.createQuery("SELECT c.getOwner() FROM Cat AS c"); // example
List<Owner> list = query.getResultList();
```

## Criteria
>website

## JPA ...
```java
public class PetStore{
	//...

	@OneToOne
	@JoinColon...
	private String address;

	//..
}
```
```java
@OneToMany(mappedBy="petStore")
private Collection<Animal> animals;
```
```java
@ManyToMany(mappedBy="products")
private Collection<PetStore> stores;
```

## Cascade
// . . .

## Lazy Loading
Les collections (ex: many to many) ne sont pas charge auto
```java
@OneToMany(mappedBy="petStore",
fetch=FetchType.Lazy)
private Collection<Animal> animals;

@OneToMany(mappedBy="petStore",
fetch=FetchType.EAGER)
private Collection<Animal>animals;
```








-----------------------------------------------
<img src="https://upload.wikimedia.org/wikipedia/commons/d/de/%D0%9B%D0%BE%D0%B3%D0%BE_%D0%B6%D0%B0%D0%B2%D0%B0.png" height="150px">
