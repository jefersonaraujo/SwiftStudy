//
//  ViewController.swift
//  IMC
//
//  Created by ios on 23/08/17.
//  Copyright © 2017 Rose. All rights reserved.
//

import UIKit


class ViewController: UIViewController {
    
    var valorImc : Float = 0.0;
    var nomeCompleto : NSString = "";
    
    var altura: Float = 0.0;
    var peso : Float = 0.0;

    
    @IBOutlet weak var tfNomeCompleto: UITextField!
    
    @IBOutlet weak var tfPeso: UITextField!
    
    @IBOutlet weak var tfAltura: UITextField!
    
    

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func limparCampos(_ sender: AnyObject) {
        tfNomeCompleto.text = nil;
        tfAltura.text = nil;
        tfPeso.text = nil;
    }
    
        
    func exibirAlerta(){
            let alerta = UIAlertController(title: "Alerta", message: "Preencha todos os campos", preferredStyle: UIAlertControllerStyle.alert);
        
            alerta.addAction(UIAlertAction(title: "OK", style: UIAlertActionStyle.default, handler: nil));
        
            self.present(alerta, animated: true, completion: nil);

        }
    
    @IBAction func calcular(_ sender: AnyObject) {
        guard let sNomeCompleto = self.tfNomeCompleto.text
            , self.tfNomeCompleto.text?.isEmpty==false else {
                exibirAlerta();
                return
        }
        
        guard let sAltura = self.tfAltura.text
            , self.tfAltura.text?.isEmpty==false else {
                exibirAlerta();
                return
        }
        
        guard let sPeso = self.tfPeso.text
            , self.tfPeso.text?.isEmpty==false else {
                exibirAlerta();
                return
        }
        
        
        //Convertendo os valores dos campos para realizar o calculo
        let alturaFloat = (sAltura as NSString).floatValue;
        let pesoFloat = (sPeso as NSString).floatValue;
        
        valorImc = (pesoFloat / (alturaFloat*alturaFloat));
        nomeCompleto = sNomeCompleto as NSString;
        
        
        self.performSegue(withIdentifier: "Resultado", sender: sender)
        
    }
    
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        
        if(segue.identifier == "Resultado"){
            let Resultado = segue.destination as?
            Resultado;
            
            Resultado?.valorImc = self.valorImc;
            Resultado?.nomeCompleto = self.nomeCompleto;
            
        }
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        print("Tocou fora de campo iterativo");
        self.becomeFirstResponder();
    }
    
}
