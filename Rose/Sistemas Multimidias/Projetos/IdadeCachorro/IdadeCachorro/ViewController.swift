//
//  ViewController.swift
//  IdadeCachorro
//
//  Created by ios on 16/08/17.
//  Copyright © 2017 Rose. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBOutlet weak var campoIdadeCachorro: UITextField!
    
    @IBOutlet weak var textoResultado: UILabel!
    @IBAction func descobrirIdade(_ sender: AnyObject) {
        var idadeCachorro = Int(campoIdadeCachorro.text!)!
        idadeCachorro = idadeCachorro * 7
        textoResultado.text = "A idade do cachorro é: " + String(idadeCachorro)
    }
    

}

