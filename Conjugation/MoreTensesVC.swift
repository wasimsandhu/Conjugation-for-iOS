//
//  MoreTensesVC.swift
//  Conjugation
//
//  Created by Wasim Sandhu on 4/18/16.
//  Copyright © 2016 Wasim Sandhu. All rights reserved.
//

import UIKit
import MessageUI

class MoreTensesVC: UIViewController, UITextFieldDelegate, UITableViewDelegate, UITableViewDataSource, MFMailComposeViewControllerDelegate {

    var moreViewController: MoreTensesVC?
    let more = ConjugateMore()
    
    @IBOutlet var otherTable: UITableView!
    @IBOutlet var otherTextField: UITextField!
    @IBOutlet var conjugateButton: UIButton!
    
    var frame: CGRect!
    
    var input: String?
    
    var isInfinitive = false
    
    var cell: CustomCell!
    
    let forms = ["Translation", "Past Participle", "Gerund", "Contact the developer"]
    
    var autoCompleteVerbs = [String]()
    @IBOutlet weak var autoCompleteTableView: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        otherTextField.delegate = self
        more.moreViewController = self
        
        frame = self.otherTextField.frame;
        frame.size.width = 10000;
        self.otherTextField.frame = frame;
        
        otherTextField.attributedPlaceholder = NSAttributedString(string: "Write the infinitive here!", attributes: [NSAttributedStringKey.foregroundColor:UIColor.white])
        
        self.otherTable.backgroundColor = UIColor.groupTableViewBackground
        
        autoCompleteTableView.isScrollEnabled = true
        autoCompleteTableView.isHidden = true
    }
    
    /* TABLE VIEW SETUP */
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        var count: Int?
        
        if tableView == self.otherTable {
            count = 4
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
                } else if ((indexPath as NSIndexPath).row == 3) {
                    cell!.accessoryType = UITableViewCellAccessoryType.disclosureIndicator
                }
            } else {
                if ((indexPath as NSIndexPath).row == 3) {
                    cell!.accessoryType = UITableViewCellAccessoryType.disclosureIndicator
                    cell!.otherVerb.text = " "
                } else {
                    cell!.otherVerb.text = " "
                }
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
        if tableView == self.autoCompleteTableView {
            let selectedCell = autoCompleteTableView.cellForRow(at: indexPath) as! CustomCell
            otherTextField.text = selectedCell.autoCompleteVerbLabel.text
            textFieldShouldReturn(otherTextField)
        } else if tableView == self.otherTable {
            if indexPath.row == 3 {
                let mailComposerVC = MFMailComposeViewController()
                mailComposerVC.mailComposeDelegate = self
                mailComposerVC.setToRecipients(["wasim@wasimsandhu.com"])
                mailComposerVC.setSubject("App Feedback: Conjugation")
                mailComposerVC.setMessageBody("", isHTML: false)
                presentMailComposeViewController(mailComposeViewController: mailComposerVC)
                tableView.deselectRow(at: indexPath, animated: true)
            } else {
                tableView.deselectRow(at: indexPath, animated: true)
            }
        }
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
    
    func presentMailComposeViewController(mailComposeViewController: MFMailComposeViewController) {
        if MFMailComposeViewController.canSendMail() {
            self.present(mailComposeViewController, animated: true, completion: nil)
        } else {
            let sendMailErrorAlert = UIAlertController.init(title: "Error", message: "Unable to send email. Please check your email settings and try again.", preferredStyle: .alert)
            self.present(sendMailErrorAlert, animated: true, completion: nil)
        }
    }
    
    public func mailComposeController(_ controller: MFMailComposeViewController, didFinishWith result: MFMailComposeResult, error: Error?) { switch (result) {
    case .cancelled:
        self.dismiss(animated: true, completion: nil)
    case .sent:
        self.dismiss(animated: true, completion: nil)
    case .failed:
        self.dismiss(animated: true, completion: {
            let sendMailErrorAlert = UIAlertController.init(title: "Failed", message: "Unable to send email. Please check your email settings and try again.", preferredStyle: .alert)
            sendMailErrorAlert.addAction(UIAlertAction.init(title: "OK", style: .default, handler: nil))
            self.present(sendMailErrorAlert, animated: true, completion: nil)
        })
    default: break;
        }
    }
    
}
