  open Coup

  let affiche_tableau l =
    List.iter (fun x -> Printf.printf "\t%s" (to_string x)) l;
    Printf.printf "\n";
    ListLabels.iter l ~f:(fun x ->
      Printf.printf "%s\t" (to_string x);
      ListLabels.iter l ~f:(fun y ->
        Printf.printf "%s\t" (if x = y then "" else if x >> y then "<" else "|")
      );
      Printf.printf "\n"
    )

  let () =
    let coups =
      Printf.printf "Voulez-vous jouer avec le puits ? %!";
      match read_line () with
      | "oui" | "yes" -> Coup.coups
      | x ->
        if x <> "non" && x <> "no" then
          Printf.printf "On va dire que non...\n";
        List.map (fun x -> Std x) Standard.coups
    in
    Printf.printf "Petit rappel des règles :\n";
    affiche_tableau coups;
    let ordi, joueur = ref 0, ref 0 in
    let rec boucle () =
      let mien = List.nth coups (Random.int (List.length coups)) in
      Printf.printf "Que jouez-vous ? %!";
      match read_line () with
      | "" -> () (* on ne se rappelle pas *)
      | cmd ->
        begin try
          let sien =
            if coups == Coup.coups then
              of_string (String.lowercase_ascii cmd)
            else
              Std (Standard.of_string (String.lowercase_ascii cmd))
          in
          Printf.printf "J'avais choisi %s.\n" (to_string mien);
          if mien > sien then (
            Printf.printf "Un point pour moi !\n";
            incr ordi
          )
          else if sien > mien then (
            Printf.printf "Un point pour vous...\n";
            incr joueur
          )
        with Invalid_argument _ ->
          Printf.printf "Pas compris...\n"
        end;
        boucle () (* on recommence *)
    in
    boucle ();
    Printf.printf "Votre score : %d\n" !joueur;
    Printf.printf "Mon score : %d\n" !ordi;
    if !ordi > !joueur then
      Printf.printf "J'ai gagné !\n"
    else if !joueur > !ordi then
      Printf.printf "Vous avez gagné...\n"
    else
      Printf.printf "Égalité.\n"
