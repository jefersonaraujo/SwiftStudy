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
    
    
   
  
    var numeroRecebido:Int!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        
        if  numeroRecebido == 0{
            //imgage.image = #imageLiteral(resourceName: "moeda_cara")
            print(numeroRecebido)
            
          
        }else{
             print(numeroRecebido)
            //imgage.image = #imageLiteral(resourceName: "moeda_coroa")
            
        }
    }
    
   
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
}
