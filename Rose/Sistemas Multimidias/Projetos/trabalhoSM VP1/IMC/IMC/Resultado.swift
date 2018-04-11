//
//  Resultado.swift
//  IMC
//
//  Created by ios on 24/08/17.
//  Copyright © 2017 Rose. All rights reserved.
//

import UIKit

class Resultado: UIViewController {
    
    var valorImc : Float?
    var nomeCompleto : NSString?
  
   
    @IBOutlet weak var labelNomeCompleto: UILabel!
    @IBOutlet weak var labelResultado: UILabel!
    @IBOutlet weak var labelConclusao: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let sValorImc = NSString(format: "%.2f", valorImc!);
        
        self.labelNomeCompleto.text = "Olá \(nomeCompleto!)";
        self.labelResultado.text = "\(sValorImc)";
        self.labelConclusao.text = "\(String(describing: labelConclusao))";
        

        // Do any additional setup after loading the view.
    }
 
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
    

    @IBAction func voltar(_ sender: AnyObject) {
        self.dismiss(animated: true, completion: nil);
    }
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
