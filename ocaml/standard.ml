type coup = Pierre | Papier | Ciseaux

let coups = [Pierre; Papier; Ciseaux]
            
let to_string x =
  match x with
  | Pierre -> "pierre"
  | Papier -> "papier"
  | Ciseaux -> "ciseaux"

let of_string x =
  match x with
  | "pierre" -> Pierre
  | "papier" -> Papier
  | "ciseaux" -> Ciseaux
  | _ -> invalid_arg "Standard.of_string"

let (>>) a b =
  match a, b with
  | Pierre, Ciseaux
  | Ciseaux, Papier
  | Papier, Pierre -> true
  | _ -> false
