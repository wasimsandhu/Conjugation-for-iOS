//
//  MoreTensesVC.swift
//  Conjugation
//
//  Created by Wasim Sandhu on 4/18/16.
//  Copyright © 2016 Wasim Sandhu. All rights reserved.
//

import UIKit
import GoogleMobileAds

class MoreTensesVC: UIViewController, UITextFieldDelegate, UITableViewDelegate, UITableViewDataSource {

    var moreViewController: MoreTensesVC?
    let more = ConjugateMore()
    
    @IBOutlet var otherTable: UITableView!
    @IBOutlet var otherTextField: UITextField!
    @IBOutlet var conjugateButton: UIButton!
    
    var frame: CGRect!
    
    var input: String?
    
    var isInfinitive = false
    
    var cell: CustomCell!
    
    let forms = ["Translation", "Past Participle", "Gerund"]
    
    var autoCompleteVerbs = [String]()
    @IBOutlet weak var autoCompleteTableView: UITableView!
    @IBOutlet weak var adBannerView: GADBannerView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        otherTextField.delegate = self
        more.moreViewController = self
        
        frame = self.otherTextField.frame;
        frame.size.width = 10000;
        self.otherTextField.frame = frame;
        
        otherTextField.attributedPlaceholder = NSAttributedString(string: "Write the infinitive here!", attributes: [NSForegroundColorAttributeName:UIColor.white])
        
        self.otherTable.backgroundColor = UIColor.groupTableViewBackground
        
        autoCompleteTableView.isScrollEnabled = true
        autoCompleteTableView.isHidden = true
        
        // ADMOB
        adBannerView.adUnitID = "ca-app-pub-8279701606777726/6275340694"
        adBannerView.rootViewController = self
        
        let request = GADRequest()
        request.testDevices = ["d1f6c75a4f170a83619a4e0c133f905c"]
        
        adBannerView.load(request)
    }
    
    /* TABLE VIEW SETUP */
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        var count: Int?
        
        if tableView == self.otherTable {
            count = 3
        } else if tableView == self.autoCompleteTableView {
            count = autoCompleteVerbs.count
        }
        
        return count!
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        var cell: CustomCell?
        
        if tableView == self.otherTable {
            
            cell = self.otherTable.dequeueReusableCell(withIdentifier: "cell3", for: indexPath) as? CustomCell
            cell!.formLabel3.text = forms[(indexPath as NSIndexPath).row]
            
            if (self.more.infinitive != nil) {
                if ((indexPath as NSIndexPath).row == 0) {
                    cell!.otherVerb.text = more.translation
                } else if ((indexPath as NSIndexPath).row == 1) {
                    cell!.otherVerb.text = more.pastParticiple
                } else if ((indexPath as NSIndexPath).row == 2) {
                    cell!.otherVerb.text = more.gerund
                }
            } else {
                cell!.otherVerb.text = " "
            }
            
        } else if tableView == self.autoCompleteTableView {
            cell = self.autoCompleteTableView.dequeueReusableCell(withIdentifier: "autoCompleteRowIdentifier", for: indexPath) as? CustomCell
            let index = (indexPath as NSIndexPath).row as Int
            cell!.autoCompleteVerbLabel.text = autoCompleteVerbs[index]
        }
        
        return cell!
    }
    
    func tableView(_ tableView: UITableView, titleForHeaderInSection section: Int) -> String? {
        
        var header: String?
        
        if tableView == self.autoCompleteTableView {
            header = "Verbs"
        } else if tableView == self.otherTable {
            header = "More Cool Stuff"
        }
        
        return header!
        
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let selectedCell = autoCompleteTableView.cellForRow(at: indexPath) as! CustomCell
        otherTextField.text = selectedCell.autoCompleteVerbLabel.text
        textFieldShouldReturn(otherTextField)
    }
    
    func textFieldDidBeginEditing(_ textField: UITextField) {
        otherTextField.attributedPlaceholder = NSAttributedString(string: "")
    }
    
    /* KEYBOARD HIDE */
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        input = self.otherTextField.text
        autoCompleteTableView.isHidden = true
        textField.resignFirstResponder()
        doConjugate()
        return true
    }
    
    /* TEXT FIELD SETUP */
    func textField(_ textField: UITextField, shouldChangeCharactersIn range: NSRange, replacementString string: String) -> Bool {
        autoCompleteTableView.isHidden = false
        let substring = (textField.text! as NSString).replacingCharacters(in: range, with: string)
        searchAutocompleteEntriesWithSubstring(substring)
        return true
    }
    
    func searchAutocompleteEntriesWithSubstring(_ substring: String) {
        autoCompleteVerbs.removeAll(keepingCapacity: false)
        
        for curString in verbs {
            let myString:NSString! = curString as NSString
            let substringRange :NSRange! = myString.range(of: substring)
            
            if (substringRange.location  == 0) {
                autoCompleteVerbs.append(curString)
            }
        }
        
        autoCompleteTableView.reloadData()
    }
    
    func doConjugate() {
        if (self.otherTextField.text!.hasSuffix("ar")) { isInfinitive = true }
        if (self.otherTextField.text!.hasSuffix("er")) { isInfinitive = true }
        if (self.otherTextField.text!.hasSuffix("ir")) { isInfinitive = true }
        if (self.otherTextField.text!.hasSuffix("ír")) { isInfinitive = true }
        
        let seconds = 0.1
        let delay = seconds * Double(NSEC_PER_SEC)  // nanoseconds per seconds
        let dispatchTime = DispatchTime.now() + Double(Int64(delay)) / Double(NSEC_PER_SEC)
        
        DispatchQueue.main.asyncAfter(deadline: dispatchTime, execute: {
            if (self.isInfinitive) {
                self.more.conjugate()
            } else {
                let alert = UIAlertController(title: "No verb inputted", message: "Please enter a verb to conjugate", preferredStyle: UIAlertControllerStyle.alert)
                alert.addAction(UIAlertAction(title: "Okay", style: UIAlertActionStyle.default, handler: nil))
                self.present(alert, animated: true, completion: nil)
            }
        })
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
}
