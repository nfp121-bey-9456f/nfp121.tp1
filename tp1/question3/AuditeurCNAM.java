package question3;

/**
 * NFP121 TpIntroduction, usage de BlueJ et du "Submitter".
 * 
 * @version Mars 2019
 * @author Elie DAHER
 * @see java.lang.String, java.lang.Math
 */

public class AuditeurCNAM {
    /** l'attribut nom de chaque auditeur. */
    private String nom;
    /** l'attribut prenom de chaque auditeur. */
    private String prenom;
    /** l'attribut matricule de chaque auditeur. */
    private String matricule;
    /** l'attribut login de chaque auditeur. */
    private String login;

    /**
     * "Création", le constructeur d'un auditeur avec son nom, son prénom et son
     * matricule.
     * 
     * @param nom
     *            le nom de l'auditeur
     * @param prenom
     *            son prénom
     * @param matricule
     *            sur la carte d'inscription, près de la photo
     */
    public AuditeurCNAM(String nom, String prenom, String matricule) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
    }

    /**
     * le login au Cnam : 6 premières lettres du nom suivies de la première
     * lettre du prénom séparées de '_' . le login retourné est en minuscules,
     * le trait d'union, ou spéciaux <i>(pour unix)</i> sont remplacés par des
     * '_' pas de caractères accentués pour le login voir les classes
     * prédéfines, java.lang.String : les méthodes replaceAll, toLowerCase et
     * substring java.lang.Math : la méthode min<br>
     * <b>BlueJ : Menu Aide</b>
     * 
     * @return le login du Cnam simplifié, sans les adaptations dues aux
     *         homonymes...
     */
    public String login() {
        String n = nom;
        String p = prenom;

        /**
         * Pas de caractères accentués pour le login
         * Voici une Méthode pour soumettre un String avec accents enlever les accents
         * @return String sans accents 
         */
        n = pasAccents(n);
        p = pasAccents(p);

        /**
         * Le trait d'union, ou spéciaux <i>(pour unix)</i> sont remplacés par des '_' 
         */
        n = n.replaceAll("[^a-zA-Z0-9]+","_");
        p = p.replaceAll("[^a-zA-Z0-9]+","_");

        /**
         * Tous les caractères sont convertis en minuscules
         */
        String nm = n.toLowerCase();
        String pm = p.toLowerCase();

        /** 
         * Le login est composé des 6 premieres lettres du nom suivies de la première
         * lettre du prénom séparées de '_' 
         * 
         * Utilisation de Math.min pour eviter StringIndexOutOfBoundsException 
         */

        login = nm.substring(0,Math.min(nm.length(),6)) + "_" + pm.substring(0,1);

        return login;
    }

    /**
     * Méthode pour enlever les accents
     * Soumettre un String avec accents
     * Retourner le String sans accents
     */
    public String pasAccents(String x){
        String accents = "àâäãéèêëîïìöôòõüûùÀÂÄÃÉÈÊËÎÏÌÖÔÒÕÜÛÙ";
        //tableau regroupant les accents
        String paccents = "aaaaeeeeiiioooouuuaaaaeeeeiiioooouuu";
        //tableau ayant les mêmes lettres mais sans accents
        int l = accents.length();
        //longueur du tableau
        for(int i = 0; i<l ; i++){
            x = x.replace(accents.charAt(i), paccents.charAt(i));
        }
        return x;
    }

    /**
     * Lecture du nom de l'auditeur.
     * 
     * @return son nom
     */
    public String nom() {
        return this.nom;        
    }

    /**
     * Lecture du prénom de l'auditeur.
     * 
     * @return son prénom
     */
    public String prenom() {
        return this.prenom;
    }

    /**
     * Lecture du matricule de l'auditeur.
     * 
     * @return son matricule
     */
    public String matricule() {
        return this.matricule;
    }

    /**
     * méthode toString ( méthode redéfinie de la classe Object).
     * 
     * @return la concaténation du nom, du prénom et du login, selon cette
     *         syntaxe
     *         <code>nom() + " " + prenom() +  " login : " + login()</code>
     */
    @Override
    public String toString() {
        return nom() + " " + prenom() + " login : " + login();
    }

}
