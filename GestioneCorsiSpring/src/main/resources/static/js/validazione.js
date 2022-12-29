//queste validazioni sono asincrone e lato client (non bisogna ricaricare per vedere risultati)
$(document).ready(function(){
	$('#userForm').bootstrapValidator({
		//controllo sulla validazione per visualizzare le icone
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		 //reegole per validare i campi
		 fields : {
			nome : {
				//chi contiene messaggio errore (il div)
				container : '#infoNome',
				validators : {
					notEmpty : {
						message : 'Il campo Nome non pu&ograve; essere vuoto'
					},
					regexp : {
						regexp : /^[a-zA-Z ,.'-]{2,30}$/, //[caratteri accettati]{intervallo di numero caratteri}
						message : 'Da 2 a 30 caratteri (solo lettere)'
					}
				}
			},
			cognome : {
				//chi contiene messaggio errore (il div)
				container : '#infoCognome',
				validators : {
					notEmpty : {
						message : 'Il campo Cognome non pu&ograve; essere vuoto'
					},
					regexp : {
						regexp : /^[a-zA-Z ,.'-]{2,30}$/, //[caratteri accettati]{intervallo di numero caratteri}
						message : 'Da 2 a 30 caratteri (solo lettere)'
					}
				}
			},
			indirizzo : {
				//chi contiene messaggio errore (il div)
				container : '#infoIndirizzo',
				validators : {
					notEmpty : {
						message : 'Il campo Indirizzo non pu&ograve; essere vuoto'
					},
					regexp : {
						regexp : /^[a-zA-Z ,.'-]+[0-9]{1,4}[ /-]?[a-z0-9]?[0-9]?$/, //[caratteri accettati]{intervallo di numero caratteri}
						message : ''
					}
				}
			},
			cap : {
				//chi contiene messaggio errore (il div)
				container : '#infoCap',
				validators : {
					notEmpty : {
						message : 'Il campo Cap non pu&ograve; essere vuoto'
					},
					regexp : {
						regexp : /^[0-9]{5}$/, //[caratteri accettati]{intervallo di numero caratteri}
						message : 'Da 2 a 30 caratteri (solo lettere)'
					}
				}
			},
			data : {
				//chi contiene messaggio errore (il div)
				container : '#infoCognome',
				validators : {
					notEmpty : {
						message : 'Il campo Nascita non pu&ograve; essere vuoto'
					},
					date : {
						format : 'YYYY/MM/DD',
						message : 'Data non valida. Formato YYYY-MM-DD'
					}
				}
			},
			username : {
				//chi contiene messaggio errore (il div)
				container : '#infoUsername',
				validators : {
					notEmpty : {
						message : 'Il campo Username non pu&ograve; essere vuoto'
					},
					regexp : {
						regexp : /^[a-zA-Z0-9 ,.'-]{4,10}$/, //[caratteri accettati]{intervallo di numero caratteri}
						message : 'Da 4 a 10 caratteri (Lettere e numeri)'
					}
				}
			},
			password : {
				//chi contiene messaggio errore (il div)
				container : '#infoPassword',
				validators : {
					notEmpty : {
						message : 'Il campo Password non pu&ograve; essere vuoto'
					},
					regexp : {
						regexp : /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])[a-zA-Z\d@#$%^&+=]{7,15}$/, //[caratteri accettati]{intervallo di numero caratteri}
						message : 'Da 7 a 15 caratteri (solo lettere)'
					}
				}
			},
			email : {
				//chi contiene messaggio errore (il div)
				container : '#infoEmail',
				validators : {
					notEmpty : {
						message : 'Il campo E-Mail non pu&ograve; essere vuoto'
					},
					regexp : {
						regexp : /^[\w\-\.\+]+\@[a-z0-9\.\-]+\.[a-zA-Z]{2,4}$/, //[caratteri accettati]{intervallo di numero caratteri}
						message : 'Inserire una mail valida'
					}
				}
			}
		}
	});
});