## Coffee Craft Unofficial Port
A fork of [Coffee Craft](https://github.com/vautheman/coffeecraft) (by Victor Autheman, Rémi Bregeard), 
attempting to improve the code structure and fix some problems.
This version includes the following changes:
- Changed the patchouli book.json to allow localization
- Included complete zh_cn localization by 梦兮
- Changed the logic of placing coffee to allow drinking when not crouching but pointing at a block
- Changed the logic of coffee tooltips, using PotionUtils to show effects instead of hard coding
- Reconstructed the Item and Block registration system, removing lots of redundant classes while keeping original behaviour
- Fixed hardcoding components in tooltips
- Removed MCreator and Eclipse workspace files (elements .mcreator models .assets  .settings)