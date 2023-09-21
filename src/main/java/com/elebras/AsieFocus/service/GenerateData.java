package com.elebras.AsieFocus.service;

import com.elebras.AsieFocus.entity.*;
import com.elebras.AsieFocus.repository.*;
import com.github.javafaker.Faker;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GenerateData {
    private final Faker faker;
    private final List<Compte> compteList;
    private final List<Rubrique> rubriqueList;
    private final List<Ressource> ressourceList;
    private final List<Article> articleList;
    private final List<Pays> paysList;
    private final CompteRepository compteRepository;
    private final AnnonceRepository annonceRepository;
    private final RubriqueRepository rubriqueRepository;
    private final RessourceRepository ressourceRepository;
    private final ArticleRepository articleRepository;
    private final CommentaireRepository commentaireRepository;
    private final PaysRepository paysRepository;
    private final ComposeRepository composeRepository;
    private final FavoriRepository favoriRepository;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public GenerateData(CompteRepository compteRepository, RubriqueRepository rubriqueRepository, AnnonceRepository annonceRepository, RessourceRepository ressourceRepository, ArticleRepository articleRepository, CommentaireRepository commentaireRepository, PaysRepository paysRepository, ComposeRepository composeRepository, FavoriRepository favoriRepository, PasswordEncoder passwordEncoder) {
        this.faker = new Faker();
        this.passwordEncoder = passwordEncoder;
        this.compteList = new ArrayList<Compte>();
        this.rubriqueList = new ArrayList<Rubrique>();
        this.ressourceList = new ArrayList<Ressource>();
        this.articleList = new ArrayList<Article>();
        this.paysList = new ArrayList<Pays>();
        this.compteRepository = compteRepository;
        this.annonceRepository = annonceRepository;
        this.rubriqueRepository = rubriqueRepository;
        this.ressourceRepository = ressourceRepository;
        this.articleRepository = articleRepository;
        this.commentaireRepository = commentaireRepository;
        this.paysRepository = paysRepository;
        this.composeRepository = composeRepository;
        this.favoriRepository = favoriRepository;
    }

    @Transactional
    public void generateComptes(int nbValeurs) {
        for (int i = 0; i < nbValeurs; i++) {
            Compte compte = new Compte(faker.name().username(), passwordEncoder.encode("password"), faker.name().name(), faker.name().fullName(), faker.internet().emailAddress(), "lien/photo.jpeg");
            this.compteList.add(compte);
            this.compteRepository.save(compte);
        }
    }
    @Transactional
    public void generateAnnonces(int nbValeurs) {
        Random random = new Random();
        for(int i = 0; i < nbValeurs; i++) {
            int index = random.nextInt(this.compteList.size());
            Annonce annonce = new Annonce(faker.lorem().sentence(), faker.lorem().paragraph(), this.compteList.get(index));
            this.annonceRepository.save(annonce);
        }
    }
    @Transactional
    public void generateRubriques() {
        rubriqueList.add(new Rubrique("Économie", "Couverture complète des tendances économiques, des marchés financiers, des investissements étrangers et des entreprises leaders de l'Asie de l'Est. Restez informé sur l'évolution de l'économie dans la région."));
        rubriqueList.add(new Rubrique("Politique", "Analyse approfondie des développements politiques clés, des élections, des réformes gouvernementales et des relations diplomatiques en Asie de l'Est. Explorez les enjeux politiques qui façonnent la région."));
        rubriqueList.add(new Rubrique("Société", "Plongez dans les questions sociales, culturelles et démographiques qui touchent les pays d'Asie. Explorez des sujets tels que l'éducation, la santé, la migration et les tendances socioculturelles qui définissent la société."));
        rubriqueList.add(new Rubrique("Industrie", "Découvrez les dernières innovations, les entreprises leaders et les tendances dans divers secteurs industriels de l'Asie, de la fabrication à la technologie de pointe."));
        rubriqueList.add(new Rubrique("Technologie", "Restez à la pointe de l'innovation en suivant les développements technologiques, les startups prometteuses et les avancées de la tech en Asie. Explorez les technologies émergentes et les initiatives durables."));
        rubriqueList.add(new Rubrique("Culture", "Plongez dans la richesse de la culture asiatique de l'Est, du cinéma et de la musique aux arts visuels et à la cuisine. Découvrez les artistes, les traditions et les délices culinaires de la région."));
        rubriqueList.add(new Rubrique("International", "Suivez les actualités mondiales, les événements internationaux majeurs et les relations diplomatiques entre les pays du monde entier. Restez informé sur les développements qui ont un impact global."));
        rubriqueList.add(new Rubrique("Opinions", "Explorez des points de vue personnels, des extraits de livres, des interviews avec des experts, des personnalités et des auteurs. Plongez dans les perspectives uniques sur des sujets variés."));
        for(Rubrique rubrique : rubriqueList) {
            this.rubriqueRepository.save(rubrique);
        }
    }

    @Transactional
    public void generateRessources(int nbValeurs) {
        for(int i = 0; i < nbValeurs; i++) {
            Ressource ressource = new Ressource(faker.company().url(), faker.lorem().sentence());
            ressourceList.add(ressource);
            this.ressourceRepository.save(ressource);
        }
    }
    @Transactional
    public void generateArticles(int nbValeurs) {
        Random random = new Random();
        for(int i = 0; i < nbValeurs; i++) {
            int indexRubrique = random.nextInt(this.rubriqueList.size());
            int indexCompte = random.nextInt(this.compteList.size());
            int indexRessource = random.nextInt(this.ressourceList.size());
            Article article = new Article(faker.lorem().sentence(), faker.lorem().paragraph(), faker.lorem().paragraph(),30, rubriqueList.get(indexRubrique), compteList.get(indexCompte), ressourceList.get(indexRessource));
            articleList.add(article);
            this.articleRepository.save(article);
        }
    }

    @Transactional
    public void generateCommentaires(int nbValeurs) {
        Random random = new Random();
        for (int i = 0; i < nbValeurs; i++) {
            int indexCompte = random.nextInt(this.compteList.size());
            int indexArticle = random.nextInt(this.articleList.size());
            Commentaire commentaire = new Commentaire(faker.lorem().paragraph(),  articleList.get(indexArticle), compteList.get(indexCompte));
            this.commentaireRepository.save(commentaire);
        }
    }
    @Transactional
    public void generatePays() {
        String[] paysAsiatiques = {"Afghanistan", "Arménie", "Azerbaïdjan", "Bahreïn", "Bangladesh", "Bhoutan", "Birmanie", "Brunei", "Cambodge", "Chine", "Chypre", "Corée du Nord", "Corée du Sud", "Émirats arabes unis", "Géorgie", "Inde", "Indonésie", "Irak", "Iran", "Israël", "Japon", "Jordanie", "Kazakhstan", "Kirghizistan", "Koweït", "Laos", "Liban", "Malaisie", "Maldives", "Mongolie", "Népal", "Oman", "Ouzbékistan", "Pakistan", "Palestine", "Philippines", "Qatar", "Russie", "Arabie saoudite", "Singapour", "Sri Lanka", "Syrie", "Tadjikistan", "Taïwan", "Thaïlande", "Timor oriental", "Turkménistan", "Turquie", "Vietnam", "Yémen"};
        for(String nomPays : paysAsiatiques) {
            Pays pays = new Pays(nomPays, faker.lorem().paragraph());
            paysList.add(pays);
            this.paysRepository.save(pays);
        }
    }

    @Transactional
    public void generateComposes() {
        Random random = new Random();
        for(Article article : articleList){
            int nbPays = random.nextInt(3) + 1;
            List<Pays> composePays = new ArrayList<>();
            for(int i = 0; i < nbPays; i++) {
                int index = random.nextInt(this.paysList.size());
                Pays pays = paysList.get(index);
                if (!composePays.contains(pays)){
                    composePays.add(pays);
                    ComposeId composeId = new ComposeId(pays, article);
                    Compose compose = new Compose(composeId);
                    this.composeRepository.save(compose);
                }
            }
        }
    }

    @Transactional
    public void generateFavoris() {
        Random random = new Random();
        for(Compte compte : compteList){
            int nbArticle = random.nextInt(10) ;
            List<Article> favoriArticles = new ArrayList<Article>();
            for(int i = 0; i < nbArticle; i++) {
                int index = random.nextInt(this.articleList.size());
                Article article = articleList.get(index);
                if(!favoriArticles.contains(article)) {
                    favoriArticles.add(article);
                    FavoriId favoriId = new FavoriId(compte, article);
                    Favori favori = new Favori(favoriId);
                    this.favoriRepository.save(favori);
                }
            }
        }

    }
}

