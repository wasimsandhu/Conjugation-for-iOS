//
//  CustomCell.swift
//  Conjugation
//
//  Created by Wasim Sandhu on 4/1/16.
//  Copyright © 2016 Wasim Sandhu. All rights reserved.
//

import UIKit

class CustomCell: UITableViewCell {
    
    @IBOutlet var conjugatedVerb: UILabel!
    @IBOutlet var formLabel: UILabel!
    
    @IBOutlet var perfectVerb: UILabel!
    @IBOutlet var formLabel2: UILabel!
    
    @IBOutlet var formLabel3: UILabel!
    @IBOutlet var otherVerb: UILabel!
    
    @IBOutlet weak var autoCompleteVerbLabel: UILabel!
    @IBOutlet weak var autoCompleteVerbLabel2: UILabel!
    @IBOutlet weak var autoCompleteVerbLabel3: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
