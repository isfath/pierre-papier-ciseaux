type coup = Std of Standard.coup | Puits

let coups = Puits :: List.map (fun x -> Std x) Standard.coups

let to_string x =
  match x with
  | Puits -> "puits"
  | Std s -> Standard.to_string s

let of_string x =
  match x with
  | "puits" -> Puits
  | _ -> Std (Standard.of_string x)
             
let (>>) a b =
  match a, b with
  | _, Puits -> false
  | Puits, _ -> true
  | Std x, Std y -> Standard.(x >> y)
