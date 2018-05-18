//
//  DetalhesViewController.swift
//  CaraOuCoroa
//
//  Created by ios on 18/05/18.
//  Copyright © 2018 Ineesolutions.com.br. All rights reserved.
//

import Foundation
import UIKit

/// Classe Detalhe View Controller
class DetalhesViewController: UIViewController {
    

    @IBOutlet weak var imgMoedas: UIImageView!
    
   
    var numeroRecebido:Int!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        if  numeroRecebido == 0{
            imgMoedas.image = #imageLiteral(resourceName: "moeda_cara")
        }else{
            imgMoedas.image = #imageLiteral(resourceName: "moeda_coroa")
        }
    }
    
   
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
}
