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
     * "Cr�ation", le constructeur d'un auditeur avec son nom, son pr�nom et son
     * matricule.
     * 
     * @param nom
     *            le nom de l'auditeur
     * @param prenom
     *            son pr�nom
     * @param matricule
     *            sur la carte d'inscription, pr�s de la photo
     */
    public AuditeurCNAM(String nom, String prenom, String matricule) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
    }

    /**
     * le login au Cnam : 6 premi�res lettres du nom suivies de la premi�re
     * lettre du pr�nom s�par�es de '_' . le login retourn� est en minuscules,
     * le trait d'union, ou sp�ciaux <i>(pour unix)</i> sont remplac�s par des
     * '_' pas de caract�res accentu�s pour le login voir les classes
     * pr�d�fines, java.lang.String : les m�thodes replaceAll, toLowerCase et
     * substring java.lang.Math : la m�thode min<br>
     * <b>BlueJ : Menu Aide</b>
     * 
     * @return le login du Cnam simplifi�, sans les adaptations dues aux
     *         homonymes...
     */
    public String login() {
        String n = nom;
        String p = prenom;

        /**
         * Pas de caract�res accentu�s pour le login
         * Voici une M�thode pour soumettre un String avec accents enlever les accents
         * @return String sans accents 
         */
        n = pasAccents(n);
        p = pasAccents(p);

        /**
         * Le trait d'union, ou sp�ciaux <i>(pour unix)</i> sont remplac�s par des '_' 
         */
        n = n.replaceAll("[^a-zA-Z0-9]+","_");
        p = p.replaceAll("[^a-zA-Z0-9]+","_");

        /**
         * Tous les caract�res sont convertis en minuscules
         */
        String nm = n.toLowerCase();
        String pm = p.toLowerCase();

        /** 
         * Le login est compos� des 6 premieres lettres du nom suivies de la premi�re
         * lettre du pr�nom s�par�es de '_' 
         * 
         * Utilisation de Math.min pour eviter StringIndexOutOfBoundsException 
         */

        login = nm.substring(0,Math.min(nm.length(),6)) + "_" + pm.substring(0,1);

        return login;
    }

    /**
     * M�thode pour enlever les accents
     * Soumettre un String avec accents
     * Retourner le String sans accents
     */
    public String pasAccents(String x){
        String accents = "������������������������������������";
        //tableau regroupant les accents
        String paccents = "aaaaeeeeiiioooouuuaaaaeeeeiiioooouuu";
        //tableau ayant les m�mes lettres mais sans accents
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
     * Lecture du pr�nom de l'auditeur.
     * 
     * @return son pr�nom
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
     * m�thode toString ( m�thode red�finie de la classe Object).
     * 
     * @return la concat�nation du nom, du pr�nom et du login, selon cette
     *         syntaxe
     *         <code>nom() + " " + prenom() +  " login : " + login()</code>
     */
    @Override
    public String toString() {
        return nom() + " " + prenom() + " login : " + login();
    }

}
