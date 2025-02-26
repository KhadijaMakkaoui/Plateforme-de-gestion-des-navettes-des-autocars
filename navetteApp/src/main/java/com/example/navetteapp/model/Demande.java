package com.example.navetteapp.model;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "demandes")
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ville_depart", nullable = false)
    private String villeDepart;

    @Column(name = "ville_arrivee", nullable = false)
    private String villeArrivee;

    @Column(name = "heure_depart", nullable = false)
    private LocalTime heureDepart;

    @Column(name = "heure_arrivee", nullable = false)
    private LocalTime heureArrivee;

    @Column(name = "date_debut", nullable = false)
    private LocalDate dateDebut;

    @Column(name = "date_fin", nullable = false)
    private LocalDate dateFin;

    @Column(name = "nombre_interesses", nullable = false)
    private int nombreInteresses = 1;


    public Demande(String villeDepart, String villeArrivee, LocalTime heureDepart, LocalTime heureArrivee, LocalDate dateDebut, LocalDate dateFin, int nombreInteresses) {
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nombreInteresses = nombreInteresses;
    }

    public Demande(int id, String villeDepart, String villeArrivee, LocalTime heureDepart, LocalTime heureArrivee, LocalDate dateDebut, LocalDate dateFin, int nombreInteresses) {
        this.id = id;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nombreInteresses = nombreInteresses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public LocalTime getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(LocalTime heureDepart) {
        this.heureDepart = heureDepart;
    }

    public LocalTime getHeureArrivee() {
        return heureArrivee;
    }

    public void setHeureArrivee(LocalTime heureArrivee) {
        this.heureArrivee = heureArrivee;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public int getNombreInteresses() {
        return nombreInteresses;
    }

    public void setNombreInteresses(int nombreInteresses) {
        this.nombreInteresses = nombreInteresses;
    }
}