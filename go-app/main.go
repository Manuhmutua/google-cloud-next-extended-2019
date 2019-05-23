package main

import (
	"encoding/json"
	"html/template"
	"io/ioutil"
	"log"
	"net/http"
	"path/filepath"

	"github.com/gorilla/mux"
)

type Person struct {
	ID   string `json:"id"`
	Name string `json:"name"`
}

var People []Person

func CreatePersonEndpoint(w http.ResponseWriter, req *http.Request) {
	reqBody, _ := ioutil.ReadAll(req.Body)
	var person Person
	json.Unmarshal(reqBody, &person)

	People = append(People, person)

	json.NewEncoder(w).Encode(person)
}

func ShowSite(w http.ResponseWriter, r *http.Request) {
	filePrefix, _ := filepath.Abs("./template/")

	templates := template.Must(template.ParseFiles(filePrefix + "/welcome-template.html"))

	if name := r.FormValue("name"); name != "" {
		People[len(People)-1].Name = name;
	}

	if err := templates.ExecuteTemplate(w, "welcome-template.html", People[len(People)-1]); err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
	}

}

func main() {
	router := mux.NewRouter()
	router.HandleFunc("/", ShowSite).Methods("GET")
	router.HandleFunc("/people", CreatePersonEndpoint).Methods("POST")
	log.Fatal(http.ListenAndServe(":12345", router))
}
